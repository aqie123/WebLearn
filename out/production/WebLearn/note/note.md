一：XML
    1. BufferedReader 字符流 readLine()
    2.解析: xml解析会把xml文件在内存中创建一个树状结构树上分支叫节点
        1.DOM解析
            将xml各个部分封装为对象,通过对象
            获取xml文件信息,甚至改变xml文件信息
        2.SAX解析
            xml解析会把xml文件在内存中创建一个树状结构
            树上分支叫节点
    3.xml信息
        1.标签(Element 对象)
            标签名,属性，文本
        2.属性(Attribute 对象)
            属性名，属性值
        3.文本(Text 对象)
            文本内容
    4.DOM解析工具  Demo
        1. 官方 jaxp
        2.jdom
        3.dom4j工具 三大框架读取xml文件程序
            http://www.dom4j.org/
           读取xml的标签 常用方法 method() method2()
               1.getRootElement() 获取根标签
               2.getName()  获取标签名称
               3.element("名称") 获取第一个指定名称的子标签
               4.elements("名称") 获取指定名称的所有标签
               5.elements() 获取所有子标签
               6.addElement("name")  增加标签
               7.DocumentHelper.createDocument()   创建文档
               8.detach()  删除标签 属性
               9.getParent().remove(属性/标签)
           获取xml属性信息 method3()
           attributeValue("name")   属性值
           attribute("name")        对象
           attributes()             属性对象列表
           getName()                属性名字
           getValue()               属性值
           addAttribute("id","001")           增加属性
           setValue() 修改属性值
           addAttribute("同名") 修改属性值
           获取xml文本信息
           getText()                当前标签
           elementText("name")      子标签文本
           setText()                修改文本内容
    5. 注意
        1. xml文件中，空格和换行会作为xml内容被解析
        2. 
    6. xml文件信息封装成对象 Demo1
    7. 写出一个xml文件(内存document对象写出到硬盘xml对象) Demo2 method
    8. 修改一个xml文件 Demo2 method2
        1.读取原来xml文件
        2.操作document对象,改变xml信息
        3.修改后对象写出到xml文件中
        添加：文档 标签 属性  method3
        修改：属性值 文本内容
        删除：标签 属性
        