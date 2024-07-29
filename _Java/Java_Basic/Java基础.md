[马士兵老教程](https://www.bilibili.com/video/BV1Yt41197sM/?spm_id_from=333.337.search-card.all.click&vd_source=a42e398d41eb80ec7f1382c8981b74ce)
[马士兵](https://www.bilibili.com/video/BV1AD4y157k7/?spm_id_from=333.337.search-card.all.click&vd_source=a42e398d41eb80ec7f1382c8981b74ce)

## 初识Java

### Java 特点 (对应核心机制)

- 完全面向对象
- 平台无关，提供程序运行的解释环境 (**JVM 虚拟机**，一次编译，随处运行)
- 健壮的，没有指针、内存的申请与释放 （**Garbage collection垃圾收集机制**）

`.java` -> **编译** -> `.class` -> （JVM for different platform）类装载器class loader -> 字节码校验器 -> **解释器** -> OS

一种解释型语言：将.class文件中的命令一行一行解释为计算机能理解的命令。

### JavaDevelopmentKit vs JavaRuntimeEnvironment

JDK包含JRE，运行需要JRE，开发需要JDK。

javac 编译，java运行。

### Java class

- 一个源文件最多一个public类，必须以它命名文件名，其他类不限。
- 严格区分大小写
- 程序执行入口是main()，固定格式

```java
class Main {
    public static void main(String[] args) {
    }
}
```

## Java基础

### 基本数据类型

- 按**容量**大小排序：byte, short, char -> int -> long(L) -> float(f) -> double
- byte, short, char之间不互相转换，三者计算时首先转换为int
- 容量大->容量小：直接砍掉前面的部分，但float格式特殊，单独为小数点存储，没办法直接砍掉进行强制转换。