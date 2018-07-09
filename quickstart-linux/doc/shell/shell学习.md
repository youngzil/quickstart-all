教程网址
http://www.runoob.com/linux/linux-shell.html


Shell 教程
Shell 是一个用 C 语言编写的程序，它是用户使用 Linux 的桥梁。Shell 既是一种命令语言，又是一种程序设计语言。
Shell 是指一种应用程序，这个应用程序提供了一个界面，用户通过这个界面访问操作系统内核的服务。


Shell 环境
Shell 编程跟 java、php 编程一样，只要有一个能编写代码的文本编辑器和一个能解释执行的脚本解释器就可以了。
Linux 的 Shell 种类众多，常见的有：
Bourne Shell（/usr/bin/sh或/bin/sh）
Bourne Again Shell（/bin/bash）
C Shell（/usr/bin/csh）
K Shell（/usr/bin/ksh）
Shell for Root（/sbin/sh）
……
本教程关注的是 Bash，也就是 Bourne Again Shell，由于易用和免费，Bash 在日常工作中被广泛使用。同时，Bash 也是大多数Linux 系统默认的 Shell。
在一般情况下，人们并不区分 Bourne Shell 和 Bourne Again Shell，所以，像 #!/bin/sh，它同样也可以改为 #!/bin/bash。
#! 告诉系统其后路径所指定的程序即是解释此脚本文件的 Shell 程序。
#! 是一个约定的标记，它告诉系统这个脚本需要什么解释器来执行，即使用哪一种 Shell。


新建一个文件 test.sh，扩展名为 sh（sh代表shell），扩展名并不影响脚本执行，见名知意就好，如果你用 php 写 shell 脚本，扩展名就用 php 好了。


运行 Shell 脚本有两种方法：
1、作为可执行程序
将上面的代码保存为 test.sh，并 cd 到相应目录：
chmod +x ./test.sh  #使脚本具有执行权限
./test.sh  #执行脚本
注意，一定要写成 ./test.sh，而不是 test.sh，运行其它二进制的程序也一样，直接写 test.sh，linux 系统会去 PATH 里寻找有没有叫 test.sh 的，而只有 /bin, /sbin, /usr/bin，/usr/sbin 等在 PATH 里，你的当前目录通常不在 PATH 里，所以写成 test.sh 是会找不到命令的，要用 ./test.sh 告诉系统说，就在当前目录找。

2、作为解释器参数
这种运行方式是，直接运行解释器，其参数就是 shell 脚本的文件名，如：
/bin/sh test.sh
/bin/php test.php
这种方式运行的脚本，不需要在第一行指定解释器信息，写了也没用。

sh/bash/csh/Tcsh/ksh/pdksh等shell的区别
sh(全称 Bourne Shell): 是UNIX最初使用的 shell，而且在每种 UNIX 上都可以使用。
Bourne Shell 在 shell 编程方面相当优秀，但在处理与用户的交互方面做得不如其他几种 shell。
bash（全称 Bourne Again Shell）: LinuxOS 默认的，它是 Bourne Shell 的扩展。
与 Bourne Shell 完全兼容，并且在 Bourne Shell 的基础上增加了很多特性。可以提供命令补全，命令编辑和命令历史等功能。它还包含了很多 C Shell 和 Korn Shell 中的优点，有灵活和强大的编辑接口，同时又很友好的用户界面。
csh(全称 C Shell): 是一种比 Bourne Shell更适合的变种 Shell，它的语法与 C 语言很相似。
Tcsh: 是 Linux 提供的 C Shell 的一个扩展版本。
Tcsh 包括命令行编辑，可编程单词补全，拼写校正，历史命令替换，作业控制和类似 C 语言的语法，他不仅和 Bash Shell 提示符兼容，而且还提供比 Bash Shell 更多的提示符参数。
ksh (全称 Korn Shell): 集合了 C Shell 和 Bourne Shell 的优点并且和 Bourne Shell 完全兼容。
 pdksh: 是 Linux 系统提供的 ksh 的扩展。
pdksh 支持人物控制，可以在命令行上挂起，后台执行，唤醒或终止程序。


如果不好理解的话，Shell 个人感觉可以对应成 win 中的 bat，通过代码来实现一些自动定时任务，自动备份或者执行的任务。
1、chmod +x file 加上执行权限，否则会提示无执行权限。
2、注意执行脚本时候或者全目录，或者 ./file.sh ，如果不加的话，linux 默认会从PATH 里去找该 file.sh。
3、看了这篇教程，发现脚本后缀名可以任意修改，仍然可以正常运行。
4、语法类PHP，方便学习。

首先，什么是脚本语言？
脚本语言是像剧本一样教计算机办某个事情的语言。
比如你想让计算机执行复制某个文件的操作，如：cp ~/Desktop/*.txt ~/text
你可以在文本编辑器写入上边的代码并且保存此文件，然后你通过执行这个文本文件来执行上面的代码，并不需要重复手动输入上边的代码。
下面这句话是我在网上看到的：
所以脚本其实就是短小的、用来让计算机自动化完成一系列工作的程序，这类程序可以用文本编辑器修改，不需要编译，通常是解释运行的。


Shell 变量
定义变量时，变量名不加美元符号（$，PHP语言中变量需要），如：
your_name="runoob.com"
注意，变量名和等号之间不能有空格，这可能和你熟悉的所有编程语言都不一样。同时，变量名的命名须遵循如下规则：
命名只能使用英文字母，数字和下划线，首个字符不能以数字开头。
中间不能有空格，可以使用下划线（_）。
不能使用标点符号。
不能使用bash里的关键字（可用help命令查看保留关键字）。

除了显式地直接赋值，还可以用语句给变量赋值，如：
for file in `ls /etc`
以上语句将 /etc 下目录的文件名循环出来。


使用变量
使用一个定义过的变量，只要在变量名前面加美元符号即可，如：
your_name="qinjx"
echo $your_name
echo ${your_name}
变量名外面的花括号是可选的，加不加都行，加花括号是为了帮助解释器识别变量的边界，
for skill in Ada Coffe Action Java; do
    echo "I am good at ${skill}Script"
done
如果不给skill变量加花括号，写成echo "I am good at $skillScript"，解释器就会把$skillScript当成一个变量（其值为空），代码执行结果就不是我们期望的样子了。
推荐给所有变量加上花括号，这是个好的编程习惯。

已定义的变量，可以被重新定义，如：
your_name="tom"
echo $your_name
your_name="alibaba"
echo $your_name
这样写是合法的，但注意，第二次赋值的时候不能写$your_name="alibaba"，使用变量的时候才加美元符（$）。


只读变量
使用 readonly 命令可以将变量定义为只读变量，只读变量的值不能被改变。
下面的例子尝试更改只读变量，结果报错：
#!/bin/bash
myUrl="http://www.w3cschool.cc"
readonly myUrl
myUrl="http://www.runoob.com"


删除变量
使用 unset 命令可以删除变量。语法：
unset variable_name
变量被删除后不能再次使用。unset 命令不能删除只读变量。


变量类型
运行shell时，会同时存在三种变量：
1) 局部变量 局部变量在脚本或命令中定义，仅在当前shell实例中有效，其他shell启动的程序不能访问局部变量。
2) 环境变量 所有的程序，包括shell启动的程序，都能访问环境变量，有些程序需要环境变量来保证其正常运行。必要的时候shell脚本也可以定义环境变量。
3) shell变量 shell变量是由shell程序设置的特殊变量。shell变量中有一部分是环境变量，有一部分是局部变量，这些变量保证了shell的正常运行


Shell 字符串
字符串是shell编程中最常用最有用的数据类型（除了数字和字符串，也没啥其它类型好用了），字符串可以用单引号，也可以用双引号，也可以不用引号。单双引号的区别跟PHP类似。

单引号
str='this is a string'
单引号字符串的限制：
单引号里的任何字符都会原样输出，单引号字符串中的变量是无效的；
单引号字串中不能出现单引号（对单引号使用转义符后也不行）。

双引号
your_name='qinjx'
str="Hello, I know your are \"$your_name\"! \n"

双引号的优点：
双引号里可以有变量
双引号里可以出现转义字符

拼接字符串
your_name="qinjx"
greeting="hello, "$your_name" !"
greeting_1="hello, ${your_name} !"
echo $greeting $greeting_1

获取字符串长度
string="abcd"
echo ${#string} #输出 4

提取子字符串
以下实例从字符串第 2 个字符开始截取 4 个字符：
string="runoob is a great site"
echo ${string:1:4} # 输出 unoo

查找子字符串
查找字符 "i 或 s" 的位置：
string="runoob is a great company"
echo `expr index "$string" is`  # 输出 8
注意： 以上脚本中 "`" 是反引号，而不是单引号 "'"，不要看错了哦。


Shell 数组
bash支持一维数组（不支持多维数组），并且没有限定数组的大小。
类似与C语言，数组元素的下标由0开始编号。获取数组中的元素要利用下标，下标可以是整数或算术表达式，其值应大于或等于0。
定义数组
在Shell中，用括号来表示数组，数组元素用"空格"符号分割开。定义数组的一般形式为：
数组名=(值1 值2 ... 值n)
还可以单独定义数组的各个分量：
array_name[0]=value0
array_name[1]=value1
array_name[n]=valuen
可以不使用连续的下标，而且下标的范围没有限制。


读取数组
读取数组元素值的一般格式是：
${数组名[下标]}
使用@符号可以获取数组中的所有元素，例如：
echo ${array_name[@]}


获取数组的长度
获取数组长度的方法与获取字符串长度的方法相同，例如：
# 取得数组元素的个数
length=${#array_name[@]}
# 或者
length=${#array_name[*]}
# 取得数组单个元素的长度
lengthn=${#array_name[n]}



Shell 注释
以"#"开头的行就是注释，会被解释器忽略。
sh里没有多行注释，只能每一行加一个#号。
如果在开发过程中，遇到大段的代码需要临时注释起来，过一会儿又取消注释，怎么办呢？
每一行加个#符号太费力了，可以把这一段要注释的代码用一对花括号括起来，定义成一个函数，没有地方调用这个函数，这块代码就不会执行，达到了和注释一样的效果。


Linux 的字符串截取很有用。有八种方法。
假设有变量 var=http://www.aaa.com/123.htm

1. # 号截取，删除左边字符，保留右边字符。
echo ${var#*//}
其中 var 是变量名，# 号是运算符，*// 表示从左边开始删除第一个 // 号及左边的所有字符
即删除 http://
结果是 ：www.aaa.com/123.htm

2. ## 号截取，删除左边字符，保留右边字符。
echo ${var##*/}
##*/ 表示从左边开始删除最后（最右边）一个 / 号及左边的所有字符
即删除 http://www.aaa.com/
结果是 123.htm

3. %号截取，删除右边字符，保留左边字符
echo ${var%/*}
%/* 表示从右边开始，删除第一个 / 号及右边的字符
结果是：http://www.aaa.com

4. %% 号截取，删除右边字符，保留左边字符
echo ${var%%/*}
%%/* 表示从右边开始，删除最后（最左边）一个 / 号及右边的字符
结果是：http:

5. 从左边第几个字符开始，及字符的个数
echo ${var:0:5}
其中的 0 表示左边第一个字符开始，5 表示字符的总个数。
结果是：http:

6. 从左边第几个字符开始，一直到结束。
echo ${var:7}
其中的 7 表示左边第8个字符开始，一直到结束。
结果是 ：www.aaa.com/123.htm

7. 从右边第几个字符开始，及字符的个数
echo ${var:0-7:3}
其中的 0-7 表示右边算起第七个字符开始，3 表示字符的个数。
结果是：123

8. 从右边第几个字符开始，一直到结束。
echo ${var:0-7}
表示从右边第七个字符开始，一直到结束。
结果是：123.htm
注：（左边的第一个字符是用 0 表示，右边的第一个字符用 0-1 表示）


述的有点儿不容易懂，看了好久才勉强明白 # ## % %%。
#、## 表示从左边开始删除。一个 # 表示从左边删除到第一个指定的字符；两个 # 表示从左边删除到最后一个指定的字符。
%、%% 表示从右边开始删除。一个 % 表示从右边删除到第一个指定的字符；两个 % 表示从左边删除到最后一个指定的字符。
删除包括了指定的字符本身。


Shell 传递参数
我们可以在执行 Shell 脚本时，向脚本传递参数，脚本内获取参数的格式为：$n。n 代表一个数字，1 为执行脚本的第一个参数，2 为执行脚本的第二个参数，以此类推……

另外，还有几个特殊字符用来处理参数：
参数处理	说明
$#	传递到脚本的参数个数
$*	以一个单字符串显示所有向脚本传递的参数。
如"$*"用「"」括起来的情况、以"$1 $2 … $n"的形式输出所有参数。
$$	脚本运行的当前进程ID号
$!	后台运行的最后一个进程的ID号
$@	与$*相同，但是使用时加引号，并在引号中返回每个参数。
如"$@"用「"」括起来的情况、以"$1" "$2" … "$n" 的形式输出所有参数。
$-	显示Shell使用的当前选项，与set命令功能相同。
$?	显示最后命令的退出状态。0表示没有错误，其他任何值表明有错误。

$* 与 $@ 区别：
相同点：都是引用所有参数。
不同点：只有在双引号中体现出来。假设在脚本运行时写了三个参数 1、2、3，，则 " * " 等价于 "1 2 3"（传递了一个参数），而 "@" 等价于 "1" "2" "3"（传递了三个参数）。


Shell 数组
数组中可以存放多个值。Bash Shell 只支持一维数组（不支持多维数组），初始化时不需要定义数组大小（与 PHP 类似）。
与大部分编程语言类似，数组元素的下标由0开始。
Shell 数组用括号来表示，元素用"空格"符号分割开，语法格式如下：
array_name=(value1 ... valuen)

读取数组
读取数组元素值的一般格式是：
${array_name[index]}

获取数组中的所有元素
使用@ 或 * 可以获取数组中的所有元素


Shell 基本运算符
Shell 和其他编程语言一样，支持多种运算符，包括：
算数运算符
关系运算符
布尔运算符
字符串运算符
文件测试运算符
原生bash不支持简单的数学运算，但是可以通过其他命令来实现，例如 awk 和 expr，expr 最常用。
expr 是一款表达式计算工具，使用它能完成表达式的求值操作。


算术运算符
下表列出了常用的算术运算符，假定变量 a 为 10，变量 b 为 20：
运算符	说明	举例
+	加法	`expr $a + $b` 结果为 30。
-	减法	`expr $a - $b` 结果为 -10。
*	乘法	`expr $a \* $b` 结果为  200。
/	除法	`expr $b / $a` 结果为 2。
%	取余	`expr $b % $a` 结果为 0。
=	赋值	a=$b 将把变量 b 的值赋给 a。
==	相等。用于比较两个数字，相同则返回 true。	[ $a == $b ] 返回 false。
!=	不相等。用于比较两个数字，不相同则返回 true。	[ $a != $b ] 返回 true。
注意：条件表达式要放在方括号之间，并且要有空格，例如: [$a==$b] 是错误的，必须写成 [ $a == $b ]。
乘号(*)前边必须加反斜杠(\)才能实现乘法运算；
if...then...fi 是条件语句，后续将会讲解。
在 MAC 中 shell 的 expr 语法是：$((表达式))，此处表达式中的 "*" 不需要转义符号 "\" 。


关系运算符
关系运算符只支持数字，不支持字符串，除非字符串的值是数字。
下表列出了常用的关系运算符，假定变量 a 为 10，变量 b 为 20：
运算符	说明	举例
-eq	检测两个数是否相等，相等返回 true。	[ $a -eq $b ] 返回 false。
-ne	检测两个数是否相等，不相等返回 true。	[ $a -ne $b ] 返回 true。
-gt	检测左边的数是否大于右边的，如果是，则返回 true。	[ $a -gt $b ] 返回 false。
-lt	检测左边的数是否小于右边的，如果是，则返回 true。	[ $a -lt $b ] 返回 true。
-ge	检测左边的数是否大于等于右边的，如果是，则返回 true。	[ $a -ge $b ] 返回 false。
-le	检测左边的数是否小于等于右边的，如果是，则返回 true。	[ $a -le $b ] 返回 true。

EQ 就是 EQUAL等于 = 
NE 就是 NOT EQUAL不等于 <>
GT 就是 GREATER THAN大于　>
LT 就是 LESS THAN小于 <
GE 就是 GREATER THAN OR EQUAL 大于等于 >=
LE 就是 LESS THAN OR EQUAL 小于等于 <=



布尔运算符
下表列出了常用的布尔运算符，假定变量 a 为 10，变量 b 为 20：
运算符	说明	举例
!	非运算，表达式为 true 则返回 false，否则返回 true。	[ ! false ] 返回 true。
-o	或运算，有一个表达式为 true 则返回 true。	[ $a -lt 20 -o $b -gt 100 ] 返回 true。
-a	与运算，两个表达式都为 true 才返回 true。	[ $a -lt 20 -a $b -gt 100 ] 返回 false。

o 应该是or的意思
a 应该是and的意思


逻辑运算符
以下介绍 Shell 的逻辑运算符，假定变量 a 为 10，变量 b 为 20:
运算符	说明	举例
&&	逻辑的 AND	[[ $a -lt 100 && $b -gt 100 ]] 返回 false
||	逻辑的 OR	[[ $a -lt 100 || $b -gt 100 ]] 返回 true



字符串运算符
下表列出了常用的字符串运算符，假定变量 a 为 "abc"，变量 b 为 "efg"：
运算符	说明	举例
=	检测两个字符串是否相等，相等返回 true。	[ $a = $b ] 返回 false。
!=	检测两个字符串是否相等，不相等返回 true。	[ $a != $b ] 返回 true。
-z	检测字符串长度是否为0，为0返回 true。	[ -z $a ] 返回 false。
-n	检测字符串长度是否为0，不为0返回 true。	[ -n $a ] 返回 true。
str	检测字符串是否为空，不为空返回 true。	[ $a ] 返回 true。


-z 应该就是zero的意思
-n 应该是？



文件测试运算符
文件测试运算符用于检测 Unix 文件的各种属性。
属性检测描述如下：
操作符	说明	举例
-b file	检测文件是否是块设备文件，如果是，则返回 true。	[ -b $file ] 返回 false。
-c file	检测文件是否是字符设备文件，如果是，则返回 true。	[ -c $file ] 返回 false。
-d file	检测文件是否是目录，如果是，则返回 true。	[ -d $file ] 返回 false。
-f file	检测文件是否是普通文件（既不是目录，也不是设备文件），如果是，则返回 true。	[ -f $file ] 返回 true。
-g file	检测文件是否设置了 SGID 位，如果是，则返回 true。	[ -g $file ] 返回 false。
-k file	检测文件是否设置了粘着位(Sticky Bit)，如果是，则返回 true。	[ -k $file ] 返回 false。
-p file	检测文件是否是有名管道，如果是，则返回 true。	[ -p $file ] 返回 false。
-u file	检测文件是否设置了 SUID 位，如果是，则返回 true。	[ -u $file ] 返回 false。
-r file	检测文件是否可读，如果是，则返回 true。	[ -r $file ] 返回 true。
-w file	检测文件是否可写，如果是，则返回 true。	[ -w $file ] 返回 true。
-x file	检测文件是否可执行，如果是，则返回 true。	[ -x $file ] 返回 true。
-s file	检测文件是否为空（文件大小是否大于0），不为空返回 true。	[ -s $file ] 返回 true。
-e file	检测文件（包括目录）是否存在，如果是，则返回 true。	[ -e $file ] 返回 true。


Shell echo命令
Shell 的 echo 指令与 PHP 的 echo 指令类似，都是用于字符串的输出。命令格式：
echo string
您可以使用echo实现更复杂的输出格式控制。

1.显示普通字符串:
echo "It is a test"
这里的双引号完全可以省略，以下命令与上面实例效果一致：
echo It is a test

echo输出的字符串总结
===================================================================
       能否引用变量  |  能否引用转移符  |  能否引用文本格式符(如：换行符、制表符)
单引号  |           否           |             否             |                             否
双引号  |           能           |             能             |                             能
无引号  |           能           |             能             |                             否                          
==================================================================================


Shell printf 命令
printf 命令模仿 C 程序库（library）里的 printf() 程序。
printf 由 POSIX 标准所定义，因此使用 printf 的脚本比使用 echo 移植性好。
printf 使用引用文本或空格分隔的参数，外面可以在 printf 中使用格式化字符串，还可以制定字符串的宽度、左右对齐方式等。默认 printf 不会像 echo 自动添加换行符，我们可以手动添加 \n。
printf 命令的语法：
printf  format-string  [arguments...]
参数说明：
format-string: 为格式控制字符串
arguments: 为参数列表。


printf的转义序列
序列	说明
\a	警告字符，通常为ASCII的BEL字符
\b	后退
\c	抑制（不显示）输出结果中任何结尾的换行字符（只在%b格式指示符控制下的参数字符串中有效），而且，任何留在参数里的字符、任何接下来的参数以及任何留在格式字符串中的字符，都被忽略
\f	换页（formfeed）
\n	换行
\r	回车（Carriage return）
\t	水平制表符
\v	垂直制表符
\\	一个字面上的反斜杠字符
\ddd	表示1到3位数八进制值的字符。仅在格式字符串中有效
\0ddd	表示1到3位的八进制值字符


%d %s %c %f 格式替代符详解:
d: Decimal 十进制整数 -- 对应位置参数必须是十进制整数，否则报错！
s: String 字符串 -- 对应位置参数必须是字符串或者字符型，否则报错！
c: Char 字符 -- 对应位置参数必须是字符串或者字符型，否则报错！
f: Float 浮点 -- 对应位置参数必须是数字型，否则报错！


Shell test 命令
Shell中的 test 命令用于检查某个条件是否成立，它可以进行数值、字符和文件三个方面的测试。

1、数值测试
参数	说明
-eq	等于则为真
-ne	不等于则为真
-gt	大于则为真
-ge	大于等于则为真
-lt	小于则为真
-le	小于等于则为真


2、字符串测试
参数	说明
=	等于则为真
!=	不相等则为真
-z 字符串	字符串的长度为零则为真
-n 字符串	字符串的长度不为零则为真


3、文件测试
参数	说明
-e 文件名	如果文件存在则为真
-r 文件名	如果文件存在且可读则为真
-w 文件名	如果文件存在且可写则为真
-x 文件名	如果文件存在且可执行则为真
-s 文件名	如果文件存在且至少有一个字符则为真
-d 文件名	如果文件存在且为目录则为真
-f 文件名	如果文件存在且为普通文件则为真
-c 文件名	如果文件存在且为字符型特殊文件则为真
-b 文件名	如果文件存在且为块特殊文件则为真

另外，Shell还提供了与( -a )、或( -o )、非( ! )三个逻辑操作符用于将测试条件连接起来，其优先级为："!"最高，"-a"次之，"-o"最低。


Shell 流程控制
和Java、PHP等语言不一样，sh的流程控制不可为空，如(以下为PHP流程控制写法)：
<?php
if (isset($_GET["q"])) {
    search(q);
}
else {
    // 不做任何事情
}
在sh/bash里可不能这么写，如果else分支没有语句执行，就不要写这个else。


if else
if
if 语句语法格式：

if condition
then
    command1 
    command2
    ...
    commandN 
fi
写成一行（适用于终端命令提示符）：
if [ $(ps -ef | grep -c "ssh") -gt 1 ]; then echo "true"; fi
末尾的fi就是if倒过来拼写，后面还会遇到类似的。


if else
if else 语法格式：

if condition
then
    command1 
    command2
    ...
    commandN
else
    command
fi


if else-if else
if else-if else 语法格式：

if condition1
then
    command1
elif condition2 
then 
    command2
else
    commandN
fi


for 循环
与其他编程语言类似，Shell支持for循环。
for循环一般格式为：
for var in item1 item2 ... itemN
do
    command1
    command2
    ...
    commandN
done

写成一行：
for var in item1 item2 ... itemN; do command1; command2… done;
当变量值在列表里，for循环即执行一次所有命令，使用变量名获取列表中的当前取值。命令可为任何有效的shell命令和语句。in列表可以包含替换、字符串和文件名。
in列表是可选的，如果不用它，for循环使用命令行的位置参数。



while 语句
while循环用于不断执行一系列命令，也用于从输入文件中读取数据；命令通常为测试条件。其格式为：
while condition
do
    command
done



无限循环
无限循环语法格式：
while :
do
    command
done
或者
while true
do
    command
done
或者
for (( ; ; ))


until 循环
until循环执行一系列命令直至条件为真时停止。
until循环与while循环在处理方式上刚好相反。
一般while循环优于until循环，但在某些时候—也只是极少数情况下，until循环更加有用。
until 语法格式:
until condition
do
    command
done
条件可为任意测试条件，测试发生在循环末尾，因此循环至少执行一次—请注意这一点。


case
Shell case语句为多选择语句。可以用case语句匹配一个值与一个模式，如果匹配成功，执行相匹配的命令。case语句格式如下：
case 值 in
模式1)
    command1
    command2
    ...
    commandN
    ;;
模式2）
    command1
    command2
    ...
    commandN
    ;;
esac
case工作方式如上所示。取值后面必须为单词in，每一模式必须以右括号结束。取值可以为变量或常数。匹配发现取值符合某一模式后，其间所有命令开始执行直至 ;;。
取值将检测匹配的每一个模式。一旦模式匹配，则执行完匹配模式相应命令后不再继续其他模式。如果无一匹配模式，使用星号 * 捕获该值，再执行后面的命令。
esac
case的语法和C family语言差别很大，它需要一个esac（就是case反过来）作为结束标记，每个case分支用右圆括号，用两个分号表示break。


跳出循环
在循环过程中，有时候需要在未达到循环结束条件时强制跳出循环，Shell使用两个命令来实现该功能：break和continue。

break命令
break命令允许跳出所有循环（终止执行后面的所有循环）。

continue
continue命令与break命令类似，只有一点差别，它不会跳出所有循环，仅仅跳出当前循环。



Shell 函数
linux shell 可以用户定义函数，然后在shell脚本中可以随便调用。
shell中函数的定义格式如下：
[ function ] funname [()]
{
    action;
    [return int;]
}
说明：
1、可以带function fun() 定义，也可以直接fun() 定义,不带任何参数。
2、参数返回，可以显示加：return 返回，如果不加，将以最后一条命令运行结果，作为返回值。 return后跟数值n(0-255
function可以省略，返回值必须存在，如果不显示使用return，就最后一行命令执行结果作为返回值
函数返回值在调用该函数后通过 $? 来获得。
注意：所有函数在使用前必须定义。这意味着必须将函数放在脚本开始部分，直至shell解释器首次发现它时，才可以使用。调用函数仅使用其函数名即可。


函数参数
在Shell中，调用函数时可以向其传递参数。在函数体内部，通过 $n 的形式来获取参数的值，例如，$1表示第一个参数，$2表示第二个参数...


注意，$10 不能获取第十个参数，获取第十个参数需要${10}。当n>=10时，需要使用${n}来获取参数。
另外，还有几个特殊字符用来处理参数：
参数处理	说明
$#	传递到脚本的参数个数
$*	以一个单字符串显示所有向脚本传递的参数
$$	脚本运行的当前进程ID号
$!	后台运行的最后一个进程的ID号
$@	与$*相同，但是使用时加引号，并在引号中返回每个参数。
$-	显示Shell使用的当前选项，与set命令功能相同。
$?	显示最后命令的退出状态。0表示没有错误，其他任何值表明有错误。



Shell 输入/输出重定向
大多数 UNIX 系统命令从你的终端接受输入并将所产生的输出发送回​​到您的终端。一个命令通常从一个叫标准输入的地方读取输入，默认情况下，这恰好是你的终端。同样，一个命令通常将其输出写入到标准输出，默认情况下，这也是你的终端。
重定向命令列表如下：
命令	说明
command > file	将输出重定向到 file。
command < file	将输入重定向到 file。
command >> file	将输出以追加的方式重定向到 file。
n > file	将文件描述符为 n 的文件重定向到 file。
n >> file	将文件描述符为 n 的文件以追加的方式重定向到 file。
n >& m	将输出文件 m 和 n 合并。
n <& m	将输入文件 m 和 n 合并。
<< tag	将开始标记 tag 和结束标记 tag 之间的内容作为输入。
需要注意的是文件描述符 0 通常是标准输入（STDIN），1 是标准输出（STDOUT），2 是标准错误输出（STDERR）。

STD感觉应该就是standard的意思


输出重定向
重定向一般通过在命令间插入特定的符号来实现。特别的，这些符号的语法如下所示:
command1 > file1
上面这个命令执行command1然后将输出的内容存入file1。
注意任何file1内的已经存在的内容将被新内容替代。如果要将新内容添加在文件末尾，请使用>>操作符。
输出重定向会覆盖文件内容，如果不希望文件内容被覆盖，可以使用 >> 追加到文件末尾


实例
执行下面的 who 命令，它将命令的完整的输出重定向在用户文件中(users):
who > users
执行后，并没有在终端输出信息，这是因为输出已被从默认的标准输出设备（终端）重定向到指定的文件。
你可以使用 cat 命令查看文件内容：
$ cat users


输入重定向
和输出重定向一样，Unix 命令也可以从文件获取输入，语法为：
command1 < file1
这样，本来需要从键盘获取输入的命令会转移到文件读取内容。
注意：输出重定向是大于号(>)，输入重定向是小于号(<)。


实例
接着以上实例，我们需要统计 users 文件的行数,执行以下命令：
$ wc -l users
       2 users
也可以将输入重定向到 users 文件：
$  wc -l < users
       2 
注意：上面两个例子的结果不同：第一个例子，会输出文件名；第二个不会，因为它仅仅知道从标准输入读取内容。
command1 < infile > outfile
同时替换输入和输出，执行command1，从文件infile读取内容，然后将输出写入到outfile中。


重定向深入讲解
一般情况下，每个 Unix/Linux 命令运行时都会打开三个文件：
标准输入文件(stdin)：stdin的文件描述符为0，Unix程序默认从stdin读取数据。
标准输出文件(stdout)：stdout 的文件描述符为1，Unix程序默认向stdout输出数据。
标准错误文件(stderr)：stderr的文件描述符为2，Unix程序会向stderr流中写入错误信息。
默认情况下，command > file 将 stdout 重定向到 file，command < file 将stdin 重定向到 file。

如果希望 stderr 重定向到 file，可以这样写：
$ command 2 > file

如果希望 stderr 追加到 file 文件末尾，可以这样写：
$ command 2 >> file
2 表示标准错误文件(stderr)。

如果希望将 stdout 和 stderr 合并后重定向到 file，可以这样写：
$ command > file 2>&1
或者
$ command >> file 2>&1

如果希望对 stdin 和 stdout 都重定向，可以这样写：
$ command < file1 >file2
command 命令将 stdin 重定向到 file1，将 stdout 重定向到 file2。


Here Document
Here Document 是 Shell 中的一种特殊的重定向方式，用来将输入重定向到一个交互式 Shell 脚本或程序。
它的基本的形式如下：
command << delimiter
    document
delimiter
它的作用是将两个 delimiter 之间的内容(document) 作为输入传递给 command。
注意：
结尾的delimiter 一定要顶格写，前面不能有任何字符，后面也不能有任何字符，包括空格和 tab 缩进。
开始的delimiter前后的空格会被忽略掉。

实例
在命令行中通过 wc -l 命令计算 Here Document 的行数：
$ wc -l << EOF
    欢迎来到
    菜鸟教程
    www.runoob.com
EOF
3          # 输出结果为 3 行


/dev/null 文件
如果希望执行某个命令，但又不希望在屏幕上显示输出结果，那么可以将输出重定向到 /dev/null：
$ command > /dev/null
/dev/null 是一个特殊的文件，写入到它的内容都会被丢弃；如果尝试从该文件读取内容，那么什么也读不到。但是 /dev/null 文件非常有用，将命令的输出重定向到它，会起到"禁止输出"的效果。
如果希望屏蔽 stdout 和 stderr，可以这样写：
$ command > /dev/null 2>&1
注意：0 是标准输入（STDIN），1 是标准输出（STDOUT），2 是标准错误输出（STDERR）。



$ command > file 2>&1
$ command >> file 2>&1
这里的&没有固定的意思
放在>后面的&，表示重定向的目标不是一个文件，而是一个文件描述符，内置的文件描述符如下
1 => stdout
2 => stderr
0 => stdin
换言之 2>1 代表将stderr重定向到当前路径下文件名为1的regular file中，而2>&1代表将stderr重定向到文件描述符为1的文件(即/dev/stdout)中，这个文件就是stdout在file system中的映射
而&>file是一种特殊的用法，也可以写成>&file，二者的意思完全相同，都等价于
>file 2>&1
此处&>或者>&视作整体，分开没有单独的含义


顺序问题：
find /etc -name .bashrc > list 2>&1
# 我想问为什么不能调下顺序,比如这样
find /etc -name .bashrc 2>&1 > list
这个是从左到右有顺序的

第一种
xxx > list 2>&1
先将要输出到stdout的内容重定向到文件，此时文件list就是这个程序的stdout，再将stderr重定向到stdout，也就是文件list

第二种
xxx 2>&1 > list
先将要输出到stderr的内容重定向到stdout，此时会产生一个stdout的拷贝，作为程序的stderr，而程序原本要输出到stdout的内容，依然是对接在stdout原身上的，因此第二步重定向stdout，对stdout的拷贝不产生任何影响


Shell 文件包含
和其他语言一样，Shell 也可以包含外部脚本。这样可以很方便的封装一些公用的代码作为一个独立的文件。
Shell 文件包含的语法格式如下：
. filename   # 注意点号(.)和文件名中间有一空格
或
source filename

#注：被包含的文件 filename 不需要可执行权限。









