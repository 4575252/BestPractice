本项目练习的目的:
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