本项目练习的目的:
==========================
1.工具整合使用(eclipse、git、github、maven）
2.maven helloworld 工程练习



环境配置:
下载eclipse luna、jdk、maven、github client（需要先注册帐号）
安装jdk、解压maven、解压eclipse
配置jdk和maven的环境变量JDK_HOME、MAVEN_HOME到安装目录，并添加%JDK_HOME%\bin到path路径，添加M2指向%MAVEN_HOME%\bin；添加M2到PATH路径
从命令行测试 javac、mvn命令是否正常
安装github client，会自动生成git shell和github browser，默认可能会自动生成ssh key，如果没有则进行以下步骤
打开gitshell
ssh-keygen -t rsa -C "4575252@gmail.com"//填写email地址，然后一直“回车”ok
打开本地..\.ssh\id_rsa.pub文件。此文件里面内容为刚才生成人密钥。
4. 登陆github系统。点击右上角的 Account Settings--->SSH Public keys ---> add another public keys
把你本地生成的密钥复制到里面（key文本框中）， 点击 add key 就ok了
5. 接着打开git ，测试连接是否成功
$ ssh -T git@github.com
如果提示：Hi defnngj You've successfully authenticated, but GitHub does not provide shell access. 说明你连接成功了
$ git config --global user.name "linke"//给自己起个用户名
$ git config --global user.email  "4575252@gmail.com"//填写自己的邮箱
打开eclipse, 设置ssh2,  Window > Preferences > General > Network Connections > SSH2  选择 ~/.ssh的绝对路径
github.com 创建源码库,并拷贝地址
eclipse 的 git 视图 clone 刚刚的地址, 让他指向本地某个文件夹
eclipse中创建maven工程存放于git刚clone出来的目录
然后就用可以类似svn进行版本处理了




大标题
===================================
  大标题一般显示工程名,类似html的\<h1\><br />
  你只要在标题下面跟上=====即可

  
中标题
-----------------------------------
  中标题一般显示重点项,类似html的\<h2\><br />
  你只要在标题下面输入------即可
  
### 小标题
  小标题类似html的\<h3\><br />
  小标题的格式如下 ### 小标题<br />
  注意#和标题字符中间要有空格

### 注意!!!下面所有语法的提示我都先用小标题提醒了!!! 

### 单行文本框
    这是一个单行的文本框,只要两个Tab再输入文字即可
        
### 多行文本框  
    这是一个有多行的文本框
    你可以写入代码等,每行文字只要输入两个Tab再输入文字即可
    这里你可以输入一段代码

### 比如我们可以在多行文本框里输入一段代码,来一个Java版本的HelloWorld吧
    public class HelloWorld {

  /**
   * @param args
   */
   public static void main(String[] args) {
   System.out.println("HelloWorld!");

   }

    }
### 链接
1.[点击这里你可以链接到www.google.com](http://www.google.com)<br />
2.[点击这里我你可以链接到我的博客](http://guoyunsky.iteye.com)<br />

###只是显示图片
![github](http://github.com/unicorn.png "github")

###想点击某个图片进入一个网页,比如我想点击github的icorn然后再进入www.github.com
[![image]](http://www.github.com/)
[image]: http://github.com/github.png "github"

### 文字被些字符包围
> 文字被些字符包围
>
> 只要再文字前面加上>空格即可
>
> 如果你要换行的话,新起一行,输入>空格即可,后面不接文字
> 但> 只能放在行首才有效

### 文字被些字符包围,多重包围
> 文字被些字符包围开始
>
> > 只要再文字前面加上>空格即可
>
>  > > 如果你要换行的话,新起一行,输入>空格即可,后面不接文字
>
> > > > 但> 只能放在行首才有效

### 特殊字符处理
有一些特殊字符如<,#等,只要在特殊字符前面加上转义字符\即可<br />
你想换行的话其实可以直接用html标签\<br /\>
=======
