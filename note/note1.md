一：Xpath:快速查询xml文件中节点 Demo3.java
    1. / 绝对路径
    2. // 相对路径，选择后代元素 无论层级
    3.* 匹配所有元素
    4.[] 选择条件
    5.属性通过前缀@指定
二：
    1.BBB[@*] 选择任意属性的BBB元素
    2.BBB[not(@*)] 选择没有属性的BBB元素
三：xml创建模拟登陆  Demo4
四：xml解析方法
    dom解析：xml一次性把xml内容加进内存,内存创建一个document树
            1.大文件dom解析效率低,甚至会导致内存溢出
            2.编码方式：面向对象
    SAX解析：边读边处理
            1.编码方式：基于事件
五：SAX  Demo5
    1.解析工具 org.xml.sax.*
    2.
六：事件驱动编程
    1.步骤
        1.事件源:xml
        2.事件:解析到(开始/结束)标签(包含属性) 文本内容
        3.监听器:DefaultHandler
七：疑问
    1.xml获取对象和属性 method3()
八：dtd约束 ：相对简单的,数据类型简单的
    1.hibernate  struts2
    2. 内部 dtd
    3. 外部 dtd
    4. 类别
        1.EMPTY 空标签
        2.PCDATA 普通字符串(不能包含子标签)
        3.ANY:可以包含子标签
    5.数量问题
        1.+ 一个或多个
        2.* 0个或多个
        3.? 0个或一个
    6.约束属性
        1.#REQUIRED  必须
        2.#IMPLIED   非必须
        3.fixed value 固定的
    7.属性类型
        1.CDATA:普通字符串
        2.(en1|en2) : 枚举
        3.
        4.
九：schema约束:相对复杂,功能强大,数据类型多 .xsd
    1.名称空间 声明xml受到哪个scheme文件约束
    2.xml文件 ： xmlns:名称空间="别名"
                 xsi:schemeLocation="别名 地址(scheme.xsd)"
     scheme: 