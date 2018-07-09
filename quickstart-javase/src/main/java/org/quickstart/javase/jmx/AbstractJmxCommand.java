/**
 * 项目名称：quickstart-javase 
 * 文件名：AbstractJmxCommand.java
 * 版本信息：
 * 日期：2018年6月12日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.javase.jmx;
import java.io.File;  
import java.io.IOException;  
import java.lang.reflect.Method;  
import java.net.URL;  
import java.net.URLClassLoader;  
import java.util.List;  
import java.util.Properties;  
/**
 * AbstractJmxCommand 
 *  
 * @author：yangzl@asiainfo.com
 * @2018年6月12日 下午12:43:25 
 * @since 1.0
 */
public class AbstractJmxCommand  {  
    private static final String CONNECTOR_ADDRESS =  
        "com.sun.management.jmxremote.localConnectorAddress";  
  
    public static String getJVM() {  
        return System.getProperty("java.vm.specification.vendor");  
    }  
  
    public static boolean isSunJVM() {  
        // need to check for Oracle as that is the name for Java7 onwards.  
        return getJVM().equals("Sun Microsystems Inc.") || getJVM().startsWith("Oracle");  
    }  
      
    public static void main(String[] args) {  
        args = new String[1];
        args[0] = "8878";
        if (args == null || args.length == 0) {  
            System.out.println("Usage: pid");  
            return;  
        }  
        int pid =Integer.valueOf(args[0]);  
        System.out.println(new AbstractJmxCommand().findJMXUrlByProcessId(pid));  
          
    }  
    /** 
     * Finds the JMX Url for a VM by its process id 
     * 
     * @param pid 
     *      The process id value of the VM to search for. 
     * 
     * @return the JMX Url of the VM with the given pid or null if not found. 
     */  
  //  @SuppressWarnings({ "rawtypes", "unchecked" })  
    protected String findJMXUrlByProcessId(int pid) {  
  
        if (isSunJVM()) {  
            try {  
                // Classes are all dynamically loaded, since they are specific to Sun VM  
                // if it fails for any reason default jmx url will be used  
  
                // tools.jar are not always included used by default class loader, so we  
                // will try to use custom loader that will try to load tools.jar  
  
                String javaHome = System.getProperty("java.home");  
                String tools = javaHome + File.separator +  
                        ".." + File.separator + "lib" + File.separator + "tools.jar";  
                URLClassLoader loader = new URLClassLoader(new URL[]{new File(tools).toURI().toURL()});  
  
                Class virtualMachine = Class.forName("com.sun.tools.attach.VirtualMachine", true, loader);  
                Class virtualMachineDescriptor = Class.forName("com.sun.tools.attach.VirtualMachineDescriptor", true, loader);  
  
                Method getVMList = virtualMachine.getMethod("list", (Class[])null);  
                Method attachToVM = virtualMachine.getMethod("attach", String.class);  
                Method getAgentProperties = virtualMachine.getMethod("getAgentProperties", (Class[])null);  
                Method getVMId = virtualMachineDescriptor.getMethod("id",  (Class[])null);  
  
                List allVMs = (List)getVMList.invoke(null, (Object[])null);  
  
                for(Object vmInstance : allVMs) {  
                    String id = (String)getVMId.invoke(vmInstance, (Object[])null);  
                    if (id.equals(Integer.toString(pid))) {  
  
                        Object vm = attachToVM.invoke(null, id);  
  
                        Properties agentProperties = (Properties)getAgentProperties.invoke(vm, (Object[])null);  
                        String connectorAddress = agentProperties.getProperty(CONNECTOR_ADDRESS);  
  
                        if (connectorAddress != null) {  
                            return connectorAddress;  
                        } else {  
                            break;  
                        }  
                    }  
                }  
                  
                //上面的尝试都不成功，则尝试让agent加载management-agent.jar  
                Method getSystemProperties = virtualMachine.getMethod("getSystemProperties", (Class[])null);  
                Method loadAgent = virtualMachine.getMethod("loadAgent", String.class, String.class);  
                Method detach = virtualMachine.getMethod("detach", (Class[])null);  
                for(Object vmInstance : allVMs) {  
                    String id = (String)getVMId.invoke(vmInstance, (Object[])null);  
                    if (id.equals(Integer.toString(pid))) {  
  
                        Object vm = attachToVM.invoke(null, id);  
  
                        Properties systemProperties = (Properties)getSystemProperties.invoke(vm, (Object[])null);  
                        String home = systemProperties.getProperty("java.home");  
                          
                        // Normally in ${java.home}/jre/lib/management-agent.jar but might  
                        // be in ${java.home}/lib in build environments.  
  
                        String agent = home + File.separator + "jre" + File.separator +  
                                           "lib" + File.separator + "management-agent.jar";  
                        File f = new File(agent);  
                        if (!f.exists()) {  
                            agent = home + File.separator +  "lib" + File.separator +  
                                        "management-agent.jar";  
                            f = new File(agent);  
                            if (!f.exists()) {  
                                throw new IOException("Management agent not found");  
                            }  
                        }  
                          
                        agent = f.getCanonicalPath();  
                          
                        loadAgent.invoke(vm, agent, "com.sun.management.jmxremote");  
                          
                        Properties agentProperties = (Properties)getAgentProperties.invoke(vm, (Object[])null);  
                        String connectorAddress = agentProperties.getProperty(CONNECTOR_ADDRESS);  
  
                        //detach 这个vm  
                        detach.invoke(vm, (Object[])null);  
                          
                        if (connectorAddress != null) {  
                            return connectorAddress;  
                        } else {  
                            break;  
                        }  
                    }  
                }  
            } catch (Exception ignore) {  
                ignore.printStackTrace();  
            }  
        }  
  
        return null;  
    }  
}  
