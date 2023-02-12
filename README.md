# Java学习

---

### 一、Java基础

> 1. JDK、JRE、JVM
>
>    ```markdown
>    JDK:Java Development Kit		Java开发工具
>    JRE:Java Runtime Environment	Java运行环境
>    JVM:Java Virtual Machine		Java虚拟机
>    ```
>
>    ![JDK、JRE、JVM](.\pictures\第一章 Java基础\JDK-JRE-JVM.jpg "JDK、JRE、JVM")
>
> 2. 第一个`Hello world`程序
>
>    ```java
>    package first_java_project;
>    
>    public class HelloWorld {
>    	public static void main(String[] args) {
>    		System.out.println("Hello world!");
>    	}
>    }
>    ```
>
> 3. Java程序运行机制
>
>    * 编译型：开发完成以后需要将所有的源代码都转换成可执行程序，比如 Windows 下的`.exe`文件，可执行程序里面包含的就是机器码。只要我们拥有可执行程序，就可以随时运行，不用再重新编译了，也就是“一次编译，无限次运行”。
>    * 解释性：有的编程语言可以一边执行一边转换，需要哪些源代码就转换哪些源代码，不会生成可执行程序，比如 Python、JavaScript、PHP、Shell、MATLAB等

### 二、包机制

> 包的本质就是一个一个的文件夹，目的是防止重命名文件
>
> 为了更好地组织类，Java提供了包机制，用于区分类名的命名空间。
>
> 1. 包语句的语法格式为：
>
>    ```java
>    package pkg1[.pkg2[.pkg3...]]
>    ```
>
> 2. **一般使用公司域名的倒置作为包名**，比如：`com.baidu.www`，`com.wenku.baidu`等
>
> 3. 为了能够使用某一个包的成员，我们需要在Java程序中明确导入该包。导入包的语法格式为：
>
>    ```java
>     import pkg1[.pkg2...].(classname|*)
>    ```
> 

### 三、JavaDoc生成帮助文档

> `javadoc`命令可用于生成自己的[API](https://www.zhihu.com/question/38594466)文档
>
> `javadoc`文档的参数信息：
>
> ```java
> @author		作者名
> @version	版本号
> @since		指明需要最早使用的jdk版本
> @param		参数名
> @return		返回值情况
> @throws		异常抛出情况
> ```
>
> 步骤：
>
> > 1. 在生成的class文件中输入`/**`并回车，自动生成相应的帮助文档
> >
> >    ![javadoc文档](.\pictures\第三章 JavaDoc生成帮助文档\javadoc文档.png "javadoc文档")
> >
> > 2. 打开文件.java（这里是HelloWorld.java）所在位置，并在此打开`cmd`终端（shift+右键，选择“在此处打开Powershell窗口”），输入如下命令：
> >
> >    ```cmd
> >    javadoc -encoding UTF-8 -charset UTF-8 HelloWorld.java
> >    ```
> >
> >    ![javadoc命令行](.\pictures\第三章 JavaDoc生成帮助文档\javadoc命令行.png "javadoc命令行")
> >
> >    ![执行javadoc命令后生成的文档](.\pictures\第三章 JavaDoc生成帮助文档\执行javadoc命令后生成的文档.png "执行javadoc命令后生成的文档")
> >
> > 3. 打开生成文件中的`index.html`即可看到帮助文档
> >
> >    ![打开帮助文档(index.html)](.\pictures\第三章 JavaDoc生成帮助文档\打开帮助文档(index.html).png "打开帮助文档(index.html)")

### 四、用户交互Scanner

> 1. `java`提供了`Scanner`类来获取用户的输入
>
> 2. 基本语法：
>
>    ```java
>    import java.util.Scanner;
>    Scanner in=new Scanner(System.in);
>    String str=in.nextLine();
>    ```
>
> 3. 通过`Scanner`类的`next()`与`nextLine()`方法获取输入的字符串，在读取前我们一般需要使用`hasNext()`与`hasNextLine()`判断是否还有输入的数据
>
> 4. 举个栗子(Demo01.java)
>
>    ```java
>    package com.phc.scanner;
>    import java.util.Scanner;
>                                        
>    public class Demo01 {
>                                        
>    	public static void main(String[] args) {
>    		// TODO Auto-generated method stub
>    		System.out.print("请输入内容：");
>    		Scanner in=new Scanner(System.in);
>    		                                    
>    		//判断用户有没有输入的字符串
>    		if(in.hasNext()) {
>    			String str=in.nextLine();//程序会等待用户输入
>    			System.out.print("用户输入的内容为: "+str);
>    		}
>    		//凡是属于I/O流的类如果不关闭就会一直占用资源，要养成好习惯用完就关掉
>    		in.close();
>    	}
>    }
>    ```
>
>    ![Demo01](.\pictures\第四章 用户交互Scanner\Demo01.png "Demo01")
>
>    
>
> 5. nextLine()与next()的区别
>
>    * next()
>
>      ```markdown
>      以空格符为结束符，不能得到带有空格的字符串
>      ```
>
>    * nextLine()
>
>      ```markdown
>      以Enter为结束符，即nextLine()方法返回的是输入回车之前的所有字符串，可以获得空白字符。
>      ```
>
> 6. 举个栗子
>
>    * Demo02
>
>      ```java
>      //功能:判断用户输入的类型
>      package com.phc.scanner;
>      import java.util.Scanner;
>      
>      public class Demo02 {
>      	public static void main(String[] args) {
>      		Scanner in=new Scanner(System.in);
>      		int i=0;
>      		float f=0.0f;
>      		String s="";
>      		System.out.print("请输入整数、小数或是字符串:");
>      		if(in.hasNextInt()) {//判断输入的是否为整数
>      			i=in.nextInt();
>      			System.out.println("您输入的整数为: "+i);
>      		}
>      		else if(in.hasNextFloat()) {
>      			f=in.nextFloat();
>      			System.out.println("您输入的浮点数为: "+f);
>      		}
>      		else if(in.hasNextLine()) {
>      			s=in.nextLine();
>      			System.out.println("您输入的字符串为: "+s);
>      		} 
>      		else {
>      			System.out.println("您输入的字符有误!");
>      		}
>      		in.close();
>      	}
>      }
>      ```
>
>      ![Demo02](.\pictures\第四章 用户交互Scanner\Demo02.png "Demo02")
>
>    * Demo03
>
>      ```java
>      //功能：输入数字求平均值，以非数字为结束符
>      package com.phc.scanner;
>      import java.util.Scanner;
>                                                                  
>      public class Demo03 {
>                                                                  
>      	public static void main(String[] args) {
>      		// TODO Auto-generated method stub
>      		System.out.print("请输入要求平均的数字(以非数字为结束符):");
>      		double sum=0.0;
>      		int count=0;
>      		Scanner in=new Scanner(System.in);
>      		while(in.hasNextDouble()||in.hasNextInt()) {
>      			double num=in.nextDouble();
>      			sum+=num;
>      			count++;
>      		}
>      		in.close();
>      		System.out.println("您输入的数据总和为: "+sum);
>      		System.out.println("您输入的数据的平均数等于: "+sum/count*1.0);
>      	}
>                                                                  
>      }
>      ```
>
>      ![Demo03](.\pictures\第四章 用户交互Scanner\Demo03.png "Demo03")

### 五、方法

> 1. 定义：
>
>    ```java
>    [修饰符] 返回值类型 方法名(参数类型 参数名) {
>        ...
>        方法体
>        ...
>        return 返回值;
>    } 
>    /**
>    (1)修饰符:可选的，比如-public/private/protected/static
>    (2)返回值类型:方法可能会有返回值，如没有返回值，则为void
>    */
>    ```
>
>    2. 调用方法：对象名.方法名(实参列表)
>
> 3. **方法的重载**：在一个类中，有相同的函数名称，但形参不同的函数
>
>    方法重载的规则：
>
>    * 方法名称必须相同
>   * 参数列表必须不同（参数个数不同、参数类型不同、参数排列顺序不同）
>    * 方法的返回类型可以相同也可以不同
>    * 仅仅返回值不同不足以成为方法的重载
> 

### 六、命令行传递参数

> 有时候你希望运行一个程序的时候再传递它消息。这就要靠传递命令参数给`main()`函数来实现。
>
> 1. 程序代码：
>
>    ```java
>    //通过命令行向main方法传递参数
>    package com.phc.examples;
>                      
>    public class Command_from_main {
>    	public static void main(String[] args) {
>    		// TODO Auto-generated method stub
>    		for(int i=0;i<args.length;i++) {
>    			System.out.println("arg["+i+"]="+args[i]);
>    		}
>    	}
>    }
>    ```
>
> 
>
> 2. 文件位置结构
>
>    ![文件位置结构](.\pictures\第六章 命令行传递参数\文件位置结构.png "文件位置结构")
>
> 3. 打开java文件所在位置使用终端命令行
>
>    ```cmd
>    PS E:\learn_programming_language\Java\简单的例子\src\com\phc\examples> ls
>
>
>        目录: E:\learn_programming_language\Java\简单的例子\src\com\phc\examples
>
>
>    Mode                 LastWriteTime         Length Name
> ----                 -------------         ------ ----
>    -a----         2021/12/6      9:26            271 Command_from_main.java
>    -a----         2021/12/4     16:19            348 Nine_to_nine_multiple.java
>    -a----         2021/12/4     16:18            547 Triangle.java
>
>    PS E:\learn_programming_language\Java\简单的例子\src\com\phc\examples> javac Command_from_main.java
>    PS E:\learn_programming_language\Java\简单的例子\src\com\phc\examples> ls
>
>
>        目录: E:\learn_programming_language\Java\简单的例子\src\com\phc\examples
>          Mode                 LastWriteTime         Length Name
>                             
>     ----                 -------------         ------ ----
>                             
>        -a----         2021/12/6      9:38            954 Command_from_main.class
>        -a----         2021/12/6      9:26            271 Command_from_main.java
>        -a----         2021/12/4     16:19            348 Nine_to_nine_multiple.java
>        -a----         2021/12/4     16:18            547 Triangle.java
>                             
>        PS E:\learn_programming_language\Java\简单的例子\src\com\phc\examples> cd ..
>        PS E:\learn_programming_language\Java\简单的例子\src\com\phc> cd ..
>        PS E:\learn_programming_language\Java\简单的例子\src\com> cd ..
>        PS E:\learn_programming_language\Java\简单的例子\src> java com.phc.examples
>        PS E:\learn_programming_language\Java\简单的例子\src> java com.phc.examples.Command_from_main
>        PS E:\learn_programming_language\Java\简单的例子\src> java com.phc.examples.Command_from_main Hello,everyone. This is a test for the command to delieve parameters
>        arg[0]=Hello,everyone.
>        arg[1]=This
>        arg[2]=is
>        arg[3]=a
>        arg[4]=test
>        arg[5]=for
>        arg[6]=the
>        arg[7]=command
>        arg[8]=to
>        arg[9]=delieve
>        arg[10]=parameters
>

### 七、可变参数

> 可变参数其实就类似一个数组
>
> 格式：在方法声明中，在指定参数类型后加一个省略号(...)
>
> **一个方法中只能指定一个可变参数，它必须是方法的最后一个参数。任何普通的参数必须在它之前声明**
>
> * 举个栗子
>
>   ```java
>   //使用可变参数实现求解传入数据的最大值
>   package com.phc.examples;
>   import java.util.Scanner;
>                       
>   public class Valiable_parameters {
>                       
>   	public static void main(String[] args) {
>   		// TODO Auto-generated method stub
>   		final int MAX=1000;
>   		System.out.print("请输入你想判断大小的浮点型数据,以非数字结尾:");
>   		Scanner in=new Scanner(System.in);
>   		double[] nums= new double[MAX];
>   		int j=0;
>   		while(in.hasNextDouble()) {
>   			nums[j]=in.nextDouble();
>   			j++;
>   		}
>   		Valiable_parameters vp=new Valiable_parameters();
>   		vp.Max(j,nums);
>   	}
>   	                    
>   	public double Max(int len,double... nums) {
>   		//int len=nums.length;
>   		if(len == 0) {
>   			System.out.println("没有数据来供判断!");
>   			return 0.0;
>   		}
>   		else {
>   			double max=nums[0];
>   			for(int i=1;i<len;i++) {
>   				if(max<nums[i]) {
>   					max=nums[i];
>   				}
>   			}
>   			System.out.println("传入的数据中最大值为:"+max);
>   			return max;
>   		}
>   	}
>   }
>   ```
>
>   ![使用可变参数实现传入数据最大值的求解](.\pictures\第七章 可变参数\使用可变参数实现传入数据最大值的求解.png "使用可变参数实现传入数据最大值的求解")
>

### 八、数组

> 用于存放多个相同数据类型的数据
>
> 1. 数组声明创建
>
>    首先必须声明数组变量，才能在程序中使用数组
>
>    ```java
>    dataType[] arrayRefVar;	//首选方法
>    dataType arrayRefVar[];	//C、C++语言定义数组的方法
>    ```
>
> 2. Java使用new操作符来创建数组，语法格式如下：
>
>    ```java
>    dataType[] arrayRefVar=new dataType[arraySize]
>    //arraySize表示数组的大小
>    ```
>
> 3. 数组的元素是通过索引访问的，数组索引从0开始
>
> 4. 获取数组长度
>
>    ```java
>    arrayRefVar.length
>    ```
>
> 5. 数组的四个基本特点：
>
>    * 数组长度是确定的。数组一旦被创建，它的大小就是不可改变的；
>    * 数组元素必须是相同类型，不允许出现混合类型；
>    * 数组中的元素可以是任何数据类型，包括基本类型和引用类型；
>    * 数组变量属引用类型，数组也可以看成对象，数组中的每个元素相当于该对象的成员变量；
>    * 数组本身就是对象，Java中对象是在堆中的，因此数组无论保存原始类型还是其他对象类型，数组对象本身是在堆中的。
>
> 6. 内存分析
>
>    > 1. 堆
>    >    * 存放new的对象和数组
>    >    * 可以被所有的线程共享，不会存放别的对象引用
>    > 2. 栈
>    >    * 存放基本变量类型（会包含这个基本类型的具体数值）
>    >    * 引用对象的变量（会存放这个引用在堆里面的具体地址）
>    > 3. 方法区
>    >    * 可以被所有的线程共享
>    >    * 包含了所有的class和static变量
>    >
>    > ![创建数组的内存机制](.\pictures\第八章 数组\创建数组的内存机制.png "数组的内存机制")
>
> 7. 举个栗子
>
>    ```java
>    //反转数组的元素
>    package com.phc.examples;
>
>    public class ReverseArray {
>
>    	public static void main(String[] args) {
>    		// TODO Auto-generated method stub
>    		final int arraySize=10;
>    		int[] arr=new int[arraySize];
>    		for(int k=0;k<arr.length;k++) {
>    			arr[k]=(int)(Math.random()*100);
>    		}
>    		System.out.println("原始数据为:");
>    		printArray(arr);
>    		System.out.println();
>    		arr=reverseArray(arr);
>    		System.out.println("反转后的数据为:");
>    		printArray(arr);
>    	}
>
>    	public static void printArray(int[] array) {
>    		System.out.println("------------------------");
>    		for(int i=0;i<array.length;i++) {
>    			System.out.print(array[i]+" ");
>    		}
>    	}
>
>    	public static int[] reverseArray(int[] array) {
>    		int[] result = new int[array.length];
>    		for(int i=0,j=array.length-1;i<array.length;i++,j--) {
>    			result[j]=array[i];
>    		}
>    		return result;
>    	}
>    }
>    ```
>
>    ![反转数组的执行结果](.\pictures\第八章 数组\反转数组的执行结果.png "反转数组的执行结果")
>
> 8. 二维数组
>
>    * 多维数组可以看成是数组的数组，比如二维数组就是一个特殊的一维数组，其每一个元素都是一个一维数组。
>
>    * 二维数组
>
>      ```java
>      int[][] arr=new int[2][3];//创建了一个两行三列的数组
>      //给二位数组赋值
>      for(int i=0;i<a.length;i++) {
>      	for(int j=0;j<a[i].length;j++) {
>      		a[i][j]=(int) (Math.random()*100);
>      	}
>      }
>      ```
>
> 9. Arrays类
>
>    * 数组的工具类java.util.Arrays
>
>    * 由于数组对象本身并没有什么方法可以供我们调用，但API中提供了一个工具类Arrays供我们使用，从而可以对数据对象进行一些基本的操作。
>
>    * [查看JDK帮助文档](E:\learn_programming_language\Java\Java JDK 1.8 API 中文帮助文档.CHM)
>
>    * Arrays类中的方法都是static修饰的静态方法，在使用的时候可以直接使用类名进行调用，而不用创建对象来调用
>
>    * 常用功能：
>
>      > 给数组赋值——通过fill方法
>      >
>      > 对数组排序——通过sort方法（升序）
>      >
>      > 比较数组——通过equals方法比较数组中元素值是否相等
>      >
>      > 查找数组元素——通过binarySearch方法能对**排好序**的数组进行二分查找法操作。
>
>      ```java
>      package com.phc.examples;
>      import java.util.Arrays;
>      public class ArraysClass {
>                                           
>      	public static void main(String[] args) {
>      		// TODO Auto-generated method stub
>      		final int arraySize=10;
>      		int[] a=new int[arraySize];
>      		//Arrays.fill() 用于填充数组元素
>      		Arrays.fill(a, (int)(Math.random()*100));
>      		System.out.println("使用fill填充元素后的数组值为:");
>      		//Arrays.toString() 用于将数组内的元素以String类型输出
>      		System.out.println(Arrays.toString(a));
>                                           
>      		int[] b=new int[arraySize];
>      		b=arrayRandom(b);
>      		System.out.println("原始数组的原始为:");
>      		printArray(b);
>      		//使用Arrays.sort升序
>      		System.out.println("使用Arrays.sort升序后的元素为:");
>      		Arrays.sort(b);
>      		System.out.println(Arrays.toString(b));
>      	}
>                                           
>      	public static int[] arrayRandom(int[] arrays) {
>      		for(int i=0;i<arrays.length;i++) {
>      			arrays[i]=(int)(Math.random()*100);
>      		}
>      		System.out.println();
>      		return arrays;
>      	}
>      	public static int[] printArray(int[] arrays) {
>      		for(int i=0;i<arrays.length;i++) {
>      			System.out.print(arrays[i]+" ");
>      		}
>      		System.out.println();
>      		return arrays;
>      	}
>      }
>      ```
>
>      ![Arrays自带工具](.\pictures\第八章 数组\Arrays自带工具.png "Arrays自带工具")
>
>

### 十、面向对象编程`(Object-Oriented Programming,OOP)`

> 1. 面向对象编程的本质就是：**以类的方式组织代码，以对象的形式封装数据**
>
> 2. 面向对象编程具有抽象性
>
> 3. 面向对象的三大特性：
>
>    * **封装**
>    * **继承**
>    * **多态**
>
> 4. 举个栗子
>
>    * Student类
>
>      ```java
>      //Student类
>      package com.phc.object;
>      public class Student {
>      	//属性
>      	String name;
>      	int age;
>      	double height;
>
>      	//方法
>      	public void printAttribution() {
>      		System.out.println("Hello,everyone!\n"
>      				+ "My name is "+this.name+".\n"
>      				+ "I'm "+this.age+" years old now!\n"
>      				+ "My height is "+this.height+"m.\n"
>      						+ "Nice to meet you!");
>      	}
>      }
>      ```
>
>    * Application类：用于测试
>
>      ```java
>      //用于测试的类
>      package com.phc.object;
>      public class Application {
>      	public static void main(String[] args) {
>      		// TODO Auto-generated method stub
>      		Student stu=new Student();
>      		stu.name="SEU";
>      		stu.age=22;
>      		stu.height=1.70;
>      		stu.printAttribution();
>      	}
>      }
>      ```
>
>      ![Student类与Application类](.\pictures\第十章 面向对象编程\Student类与Application类.png "Student类与Application类")
>
> 5. **构造器**
>
>    * 使用`new`关键字创建对象。使用`new`关键字创建的时候，除了分配内存空间之外，还会给创建好的对象进行**默认的初始化以及对类中构造器的调用。**
>
>    * 类中的构造器也称为构造方法，是在进行创建对象的时候必须要调用的。并且构造器有以下两个特点：
>
>      (1) 必须和类的名字相同
>
>      (2) 必须没有返回类型，也不能写void
>
>    * 举个栗子
>
>      ```java
>      //Student类
>      package com.phc.object;
>      public class Student {
>      	//属性
>      	String name;
>      	int age;
>      	double height;
>     
>      	//构造器
>      	public Student() {
>      		this.name="PHC-SEU";
>      		this.age=18;
>      		this.height=1.8;
>      	}
>      	public Student(String n) {
>      		this.name=n;
>      	}
>      	public Student(String n,int a) {
>      		this.name=n;
>      		this.age=a;
>      	}
>      	public Student(String n,int a,double h) {
>      		this.name=n;
>      		this.age=a;
>      		this.height=h;
>      	}
>     
>      	//方法
>      	public void printAttribution() {
>      		System.out.println("Hello,everyone!\n"
>      				+ "My name is "+this.name+".\n"
>      				+ "I'm "+this.age+" years old now!\n"
>      				+ "My height is "+this.height+"m.\n"
>      						+ "Nice to meet you!");
>      	}
>      }
>      ```
>
>      ```java
>      //用于测试的类
>      package com.phc.object;
>      public class Application {
>     
>      	public static void main(String[] args) {
>      		// TODO Auto-generated method stub
>      		//创建对象的时候自动调用构造函数
>      		Student stu1=new Student();
>      		Student stu2=new Student("Jack");
>      		Student stu3=new Student("Tom",13,1.6);
>      		//调用对象中的成员函数
>      		stu1.printAttribution();
>      		System.out.println();
>      		stu2.printAttribution();
>      		System.out.println();
>      		stu3.printAttribution();
>      	}
>      }
>      ```
>
>      ![构造函数](.\pictures\第十章 面向对象编程\构造函数.png "构造函数")
>
> 6. 创建对象内存分析
>
>    ```java
>    //Pet类
>    Public class Pet {
>        String name;
>        int age;
>        public static void shout() {
>            System.out.println("正在叫...");
>        }
>    }
>    //Application类
>    Public class Application {
>        public static void main(String[] args) {
>            Pet dog=new Pet();
>            Pet cat=new Pet();
>            dog.shout();
>            cat.shout();
>        }
>    }
>    ```
>
>    ![创建对象内存分析](.\pictures\第十章 面向对象编程\创建对象内存分析.jpg "创建对象内存分析")
>
> 7. **封装性**
>
>    > 该露的露，该藏的藏
>    >
>    > * 我们程序设计要最求“高内聚，低耦合”。高内聚：就是类的内部数据操作细节自己完成，不允许外部干涉；低耦合：仅仅暴露少量的方法给外部使用。
>    >
>    > 封装（数据的隐藏）
>    >
>    > * 通常，应禁止直接访问一个对象中数据的实际表示，而应通过操作接口来访问，这被称之为信息隐藏。
>    > * 属性私有化：get/set
>    >
>    > 举个栗子：
>    >
>    > ```java
>    > //Student类
>    > package com.phc.object;
>    > 
>    > public class Student {
>    > 	//私有属性（封装）
>    > 	private String name;
>    > 	private int age;
>    > 	private double score;
>    > 	
>    > 	//get、set方法
>    > 	public String getName() {
>    > 		return this.name;
>    > 	}
>    > 	public void setName(String n) {
>    > 		this.name=n;
>    > 	}
>    > 	
>    > 	public int getAge() {
>    > 		return this.age;
>    > 	}
>    > 	public void setAge(int a) {
>    > 		if(a<0||a>120) {
>    > 			System.out.println("您输入的年龄有误!");
>    > 			a=-1;
>    > 		}
>    > 		this.age=a;
>    > 	}
>    > 	
>    > 	public double getScore() {
>    > 		return this.score;
>    > 	}
>    > 	public void setScore(int s) {
>    > 		this.score=s;
>    > 	}
>    > 	
>    > 	//输出
>    > 	public void printAttribute() {
>    > 		System.out.println("Name: "+this.name);
>    > 		System.out.println("Age: "+this.age);
>    > 		System.out.println("Score: "+this.score);
>    > 	}
>    > }
>    > ```
>    >
>    > ```java
>    > //用于测试的类
>    > package com.phc.object;
>    > 
>    > public class Application {
>    > 
>    > 	public static void main(String[] args) {
>    > 		// TODO Auto-generated method stub
>    > 		//创建对象的时候自动调用构造函数
>    > 		Student stu=new Student();
>    > 		stu.printAttribute();
>    > 		System.out.println("------------");
>    > 		stu.setAge(22);
>    > 		stu.setName("SEU");
>    > 		stu.printAttribute();
>    > 		stu.setScore(98);
>    > 		System.out.println("Your score is "+stu.getScore());
>    > 	}
>    > }
>    > ```
>    >
>    > ![私有属性get-set方法](.\pictures\第十章 面向对象编程\私有属性get-set方法.png "私有属性get-set方法")
>    >
>    > 
>
> 8. 继承性
>
>    > * 继承的本质是对某一批类的抽象，从而实现对现实世界更好的建模
>    > * `extends`的意思是“扩展”。子类是父类的扩展
>    > * Java只有**单继承**，没有多继承
>    > * 继承是类与类之间的一种关系。除此之外，类和类之间的关系还有依赖、组合、聚合等
>    > * 继承关系的两个类，一个是子类（派生类），一个是父类（基类）。子类继承父类，使用关键词`extends`来表示
>    > * 子类和父类之间，从意义上讲应具有“is a”的关系。
>
>    举个栗子
>
>    * 父类
>
>      ```java
>      //父类--->Person
>      package com.phc.object;
>
>      public class Person {
>      	//私有属性
>      	private String name;
>      	private int age;
>
>      	//构造方法
>      	public Person() {
>      		this.name="Hi";
>      		this.age=18;
>      	}
>      	//get、set
>      	public String getName() {
>      		return this.name;
>      	}
>      	public void setName(String n) {
>      		this.name=n;
>      	}
>
>      	public int getAge() {
>      		return this.age;
>      	}
>      	public void setAge(int a) {
>      		this.age=a;
>      	}
>
>      	//创建一个方法
>      	public void say() {
>      		System.out.println(this.name+" 说了一句话......");
>      	}
>      }
>      ```
>
>    * 子类
>
>      ```java
>      //子类--->Teacher
>      package com.phc.object;
>
>      public class Teacher extends Person{
>      	private String subject;
>      	public String getSubject() {
>      		return this.subject;
>      	}
>      	public void setSubject(String s) {
>      		this.subject=s;
>      	}
>      }
>      ```
>
>    * 测试类
>
>      ```java
>      //用于测试的类
>      package com.phc.object;
>           
>      public class Application {
>           
>      	public static void main(String[] args) {
>      		Teacher teacher=new Teacher();
>      		//调用了父类里的函数
>      		teacher.setName("SEU");
>      		teacher.say();
>      		System.out.println("Age:"+teacher.getAge());
>      		//调用自己的set、get方法
>      		teacher.setSubject("工程矩阵");
>      		System.out.println("Subject:"+teacher.getSubject());
>      	}
>      }
>      ```
>
> ![继承](.\pictures\第十章 面向对象编程\继承.png "继承")
>
> 9. **Super**注意点
>
>    > (1) super调用父类的构造方法，必须在构造方法中的第一个
>    >
>    > (2) super必须只能出现在子类的方法或者构造方法中
>    >
>    > (3) super和this不能同时调用构造方法
>    >
>    > (4) this与super的不同点:
>    >
>    > * this: 
>    >   * 调用本身这个对象
>    >   * 没有继承也可以使用
>    >   * this()表示本类的构造
>    > * super: 
>    >   * 调用父类对象的属性和方法
>    >   * 只能在继承条件中才可以使用
>    >   * super()表示父类的构造
>
>    举个栗子
>
>    * 父类
>
>      ```java
>      //父类--->Person
>      package com.phc.object;
>
>      public class Person {
>      	//保护属性
>      	protected String name;
>      	//定义父类构造函数
>      	public Person() {
>      		this.name="Person";
>      	}
>      	public void say() {
>      		System.out.println(this.name+" 说了一句话......");
>      	}
>      }
>      ```
>
>    * 子类
>
>      ```java
>      //子类--->Teacher
>      package com.phc.object;
>      import com.phc.object.Person; //导入父类
>           
>      public class Teacher extends Person{
>           
>      	protected String name;
>      	//定义子类构造函数
>      	public Teacher() {
>      		this.name="teacher";
>      	}
>           
>      	public void say() {
>      		System.out.println(this.name+" 说了一句话......");
>      	}
>      	public void test() {
>      		say();//调用子类say()函数
>      		this.say();//调用子类say()函数，推荐使用
>      		super.say();//调用父类say()函数
>      	}
>      }
>      ```
>
> 
>
>    * 测试类
>
>      ```java
>      //用于测试的类
>      package com.phc.object;
>           
>      public class Application {
>           
>      	public static void main(String[] args) {
>      		//创建子类对象时会隐式调用父类构造方法 super();
>      		Teacher teacher=new Teacher();
>      		teacher.test();
>      	}
>      }
>      ```
>
>      ![super的用法](.\pictures\第十章 面向对象编程\super的用法.png "super的用法")
>
> 10. 方法重写：需要有继承关系，子类重写父类的方法
>
>     * 方法名必须相同
>     * 参数列表必须相同
>     * 修饰符：范围可以扩大但不能缩小（public>protected>default>private）
>     * 抛出的异常：范围可以被缩小但不能扩大(eg:Exception--->ClassNotFoundException)
>     * 重写的方法必须都**不是**static静态方法类型
>     * 重写的本质：子类的方法和父类必须要一致；但方法体不同
>     * 重写的原因：父类的功能，子类不一定需要，或者不一定满足
>
>     举个栗子
>
>     ```java
>     //父类
>     package com.phc.object;
>
>     public class A {
>     	public void test() {
>     		System.out.println("我是父类里的test函数");
>     	}
>     }
>
>     //子类
>     package com.phc.object;
>
>     public class B extends A{
>     	//重写父类的test()函数
>     	public void test() {
>     		System.out.println("我是子类的test()函数");
>     	}
>     }
>
>     //用于测试的类
>     package com.phc.object;
>
>     public class Application {
>
>     	public static void main(String[] args) {
>     		//重写父类的test()函数
>     		B b=new B();
>     		b.test();
>     		A a=new B();
>     		a.test();
>     	}
>     }
>     ```
>
>     ![子类重写父类方法](.\pictures\第十章 面向对象编程\子类重写父类方法.png "子类重写父类方法")
>
> 11. **多态**
>
>     > （1）动态编译，类型具有可扩展性
>     >
>     > （2）即同一方法可以根据发送对象的不同而采用不同的行为方式
>     >
>     > （3）一个对象的实际类型是确定的，但可以指向对象的引用的类型有很多
>     >
>     > （4）多态存在的条件：
>     >
>     > * 有继承关系
>     > * 子类重写父类方法
>     > * 父类引用指向子类对象
>     >
>     > （5）注意：多态是方法的多态，属性没有多态
>     >
>     > （6）要点：
>     >
>     > * 父类的类型可以指向子类，他可以调用父类本身存在的方法，如果子类对该方法有重写，则相当于调用子类的方法，否则才调用父类的方法。
>     > * 子类可以调用本身或者父类继承下来的方法
>     > * 父类不能调用自己本身不存在的方法，即不能调用子类独有的方法。
>     >
>     > （7）举个栗子
>     >
>     > ```java
>     > //父类
>     > package com.phc.polymorphic;
>     > 
>     > public class Person {
>     > 	public void run() {
>     > 		System.out.println("Person===>run");
>     > 	}
>     > }
>     > 
>     > //子类
>     > package com.phc.polymorphic;
>     > 
>     > public class Student extends Person{
>     > 	//重写父类的run()方法
>     > 	public void run() {
>     > 		System.out.println("Student===>run");
>     > 	}
>     > 	
>     > 	public void eat() {
>     > 		System.out.println("Student===>eat");
>     > 	}
>     > }
>     > 
>     > //测试类
>     > package com.phc.polymorphic;
>     > 
>     > public class Application {
>     > 
>     > 	public static void main(String[] args) {
>     > 		//一个对象的实际类型是确定的
>     > 		//但可以指向的引用类型就不确定了:父类的引用指向子类
>     > 		Student s1=new Student();
>     > 		Person s2=new Student();
>     > 		Object s3=new Student();
>     > 		
>     > 		//Student 能调用的方法都是自己的或者继承父类的！
>     > 		//Person  可以指向子类，但不能调用子类独有的方法!
>     > 		s1.run();
>     > 		s2.run();//子类重写了父类的方法，则执行子类的方法
>     > 		//s3.run();
>     > 		
>     > 		s1.eat();
>     > 		//s2.eat(); 父类没有eat()方法，故报错
>     > 	}
>     > }
>     > ```
>     >
>     > ![多态基础](.\pictures\第十章 面向对象编程\多态基础.png)
>     >
>
> 12. ```instanceof``` 
>
>     * 格式
>
>       ```java
>       x instanceof Y	//执行的前提是对象x所在的类与Y是否为父子关系
>       /*
>       若x是Y的，即x对象所在的类是Y的儿子或本身所在的类，则为true，否则则为false
>       */
>       ```
>
>     * 举个栗子
>
>       ```java
>       //Object类 > Person类 > Student类
>       //Object类 > Person类 > Teacher类
>       //测试类
>       package com.phc.transform;
>     
>       public class Application {
>     
>       	public static void main(String[] args) {
>       //		Object>Person>Student
>       //		Object>Person>Teacher
>       		Person person=new Person();
>       		Student student=new Student();
>       		Teacher teacher=new Teacher();
>       //		x instanceof X,[x表示对象；X表示class类],若x是X的，即x对象所在的类是X的儿子或本身所在的类，则为true，否则则为false
>       		System.out.println(person instanceof Object);
>       		System.out.println(person instanceof Person);
>       		System.out.println(person instanceof Student);
>       		System.out.println(person instanceof Teacher);
>       //		System.out.println(person instanceof String);
>       		System.out.println("============================");
>       		System.out.println(student instanceof Object);
>       		System.out.println(student instanceof Person);
>       		System.out.println(student instanceof Student);
>       //		System.out.println(student instanceof Teacher);//Student与Teacher是同级的，没有父子关系，所以编译就报错
>       	}
>       }
>       ```
>
>     ![instanceof](.\pictures\第十章 面向对象编程\instanceof.png)
>
> 13. 类型转换
>
>     * 栗子
>
>       ```java
>       Person p1=new Student();//父类引用指向子类对象
>       Student p2=(Student)p1;
>       p2.isLesson();//强制类型转换
>       ```
>
>     * 需要注意的事项：
>
>       （1）父类引用指向子类的对象
>
>       （2）把子类转换为父类，向上转型，可以自动实现
>
>       （3） 把父类转换为子类，向下转型，需要**强制转换**
>
> 14. static关键字
>
>     ```java
>    public class Static_knowledge {
>     	//static代码块
>     	static{
>     		System.out.println("我是static代码块!");
>     	}
>     
>    	{
>     		System.out.println("我是普通的代码块!");
>     	}
>     
>    	public Static_knowledge() {
>     		System.out.println("我是构造函数!");
>     	}
>     	public static void main(String[] args) {
>     		Static_knowledge sk1=new Static_knowledge();
>     		System.out.println("=====================================");
>     		Static_knowledge sk2=new Static_knowledge();
>     	}
>     }
>     ```
>     
>    ![static代码块](.\pictures\第十章 面向对象编程\static代码块.png)
>     
>15. 抽象类**（不推荐使用，推荐使用接口来代替）**
> 
>    > 1. 不能new这个抽象类，只能靠子类去实现它（是一种约束），而且继承了抽象类的子类必须实现抽象类（父类）的抽象方法；
>     >
>     > 2. 抽象类中可以写普通方法
>     >
>     > 3. 抽象方法必须在抽象类中，即若类中有抽象方法，则该类必须加上abstract声明成抽象类
>     >
>     > 4. 举个栗子
>     >
>     >    ```java
>     >    //Abstract_A
>     >    package com.phc.abstract_class;
>     >    //抽象父类
>     >    public abstract class Abstract_A {
>     >    	public abstract void sayHello();
>     >    	public abstract void sayYes();
>     >    	public void ordinary_methods() {
>     >    		System.out.println("I am an ordinary function!");
>     >    	}
>     >    }
>     >    //Abstract_B
>     >    package com.phc.abstract_class;
>     >    //实现的子类
>     >    public class Abstract_B extends Abstract_A{
>     >    	//子类继承了抽象类，则该子类必须实现抽象类的所有抽象方法
>     >    	//@override
>     >    	public void sayHello() {
>     >    		System.out.println("Hello");
>     >    	}
>     >    	public void sayYes() {
>     >    		System.out.println("Yes");
>     >    	}
>     >    }
>     >    //Application
>     >    package com.phc.abstract_class;
>     >          
>     >    public class Application {
>     >          
>     >    	public static void main(String[] args) {
>     >    		Abstract_B b=new Abstract_B();
>     >    		b.sayYes();
>     >    		b.sayHello();
>     >    		b.ordinary_methods();
>     >    	}
>     >    }
>     >    ```
>     >
>     >    ![抽象类的应用](.\pictures\第十章 面向对象编程\抽象类的应用.png)
> 
>16. 接口Interface：只有规范！自己无法写方法，实现约束和方法的分离
> 
>    > 1. **接口就是规范，定义的是一组规则。**
>     >
>     > 2. **接口的本质是契约，就像我们人类的法律一样，制定好后大家都需要遵守**
>     >
>     > 3. OO的精髓，是对对象的抽象，最能体现这一点的就是接口。
>     >
>     > 4. 声明类的关键字是class，声明接口的关键字是interface
>     >
>     > 5. 举个栗子
>     >
>     >    ```java
>     >    //接口:不能去实现方法,只能定义方法，具体的实现交给继承接口的类
>     >    package com.phc.interface_application;
>     >    public interface Calculation {
>     >    	//接口的变量--->默认为静态常量:public static final(不推荐使用)
>     >    	int AGE=22;
>     >    	//接口的方法--->默认为public abstract(推荐)
>     >    	double add(double a,double b);
>     >    	double sub(double a,double b);
>     >    	double mul(double a,double b);
>     >    	double div(double a,double b);
>     >    }
>     >          
>     >    package com.phc.interface_application;
>     >    public interface Helloworld {
>     >    	void helloworld();
>     >    }
>     >          
>     >    //继承接口的类:必须实现接口中定义的全部方法,一个类可以继承多个接口,关键字为implements
>     >    package com.phc.interface_application;
>     >          
>     >    public class CalHelloImpl implements Calculation,Helloworld{
>     >    	@Override
>     >    	public double add(double a,double b) {
>     >    		return a+b;
>     >    	}
>     >          
>     >    	@Override
>     >    	public double sub(double a, double b) {
>     >    		return a-b;
>     >    	}
>     >          
>     >    	@Override
>     >    	public double mul(double a, double b) {
>     >    		return a*b;
>     >    	}
>     >          
>     >    	@Override
>     >    	public double div(double a, double b) {
>     >    		return a/b;
>     >    	}
>     >    	      
>     >    	@Override
>     >    	public void helloworld() {
>     >    		System.out.println("Hello world!");
>     >    	}
>     >    }
>     >    ```
> 
>17. 内部类（了解即可）
> 
>    > 1. 内部类就是在一个类的内部再定义一个类，比如，A类中定义一个B类，那么B类相对于A类来说就称为内部类，而A类相对于B类来说就是外部类了。
>     > 2. 一个文件里中可以有多个class类，但是只能有一个public class类。
>     >
>     > * 成员内部类
>     > * 静态内部类
>     > * 局部内部类
>     > * 匿名内部类

### 十一、异常机制

> 1. 软件程序在运行过程中，非常可能遇到一些异常问题，我们称之为异常，英文是：*Exception*，意思是例外。这些，例外情况，或者叫异常，怎么让我们写的程序做出合理的处理。而不至于程序崩溃。
>
> * 异常指程序运行中出现的不期而至的各种状况，如：文件找不到、网络连接失败、非法参数等。
> * 异常发生在程序运行期间，它影响了正常的程序执行流程。
>
> 2. 三种类型的异常：
>
> （1）检查性异常：最具代表的检查性异常是用户错误或问题引起的异常，这是程序无法预见的。例如要打开一个不存在的文件时，一个异常就发生了，这些异常在编译时不能被简单地忽略。
>
> （2）运行时异常：运行时异常是可能被程序员避免的异常。与检查性异常相反，运行时异常可以在编译时被忽略。
>
> （3）错误(ERROR)：错误不是异常，而是脱离程序员控制的问题。错误在代码中通常被忽略。例如，当栈溢出时，一个错误就发生了，他们在编译阶段也检查不到的。
>
> 3. Java异常体系结构
>
>    * Java把异常当作对象来处理，并定义一个基类java.lang.Throwable作为所有异常的超类。
>    * 在Java API中已经定义了许多异常类，这些异常类分为两大类，错误Error和异常Exception。
>
>    ![Java异常体系结构](.\pictures\第十一章 异常机制\Java异常体系结构.jpg)
>
> 4. Error与Exception
>
>    > (1)Error
>    >
>    > * Error类对象由Java虚拟机生成并抛出，大多数错误与代码编写者所执行的操作无关。
>    > * Java虚拟机运行错误(Virtual MachineError)，当JVM不再有继续执行操作所需的内存资源时，将出现OutOfMemoryError。这些异常发生时，Java虚拟机(JVM)一般会选择线程终止；
>    > * 还有发生在虚拟机试图执行应用时，如类定义错误(NoClassDefFoundError)，链接错误(LinkageError)。这些错误是不可查的，因为它们在应用程序的控制和处理能力之外，而且绝大多数是程序运行时不允许出现的状况。
>    >
>    > (2)Exception
>    >
>    > ![Error与Exception的区别](.\pictures\第十一章 异常机制\Error与Exception的区别.png "Error与Exception的区别")
>
> 5. 异常的处理机制
>
>    * 抛出异常:throw throws
>    * 捕获异常:catch
>    * 异常处理的五个关键字：
>
>    ```java
>    try:监控区域
>    catch:捕获异常
>    finally:无论如何都会被执行
>    throw:方法体内部抛出异常 
>    throws:方法声明中抛出异常
>    ```
>
>    ![try-catch-finally](.\pictures\第十一章 异常机制\try-catch-finally.png)
>
> 6. ```Throws```举个栗子
>
>    ```java
>    package com.phc.examples;
>    import java.util.Scanner;
>    
>    public class Try_catch_finally_throws {
>    	public static void main(String[] args) {
>    		try {
>    			Scanner in=new Scanner(System.in);
>    			System.out.print("Please input two integer number(Seperated by space):");
>    			int a=0,b=0;
>    			a=in.nextInt();
>    			b=in.nextInt();
>    			Try_catch_finally_throws t=new Try_catch_finally_throws();
>    			t.division(a,b);
>    		}
>    		catch(ArithmeticException e1) {
>    			System.out.println("触发了ArithmeticException保护机制!");
>    			System.out.println("除数不能为0!");
>    			e1.printStackTrace();
>    		}
>    		catch(RuntimeException e2) {
>    			System.out.println("触发了RuntimeException保护机制!");
>    			e2.printStackTrace();
>    		}
>    		catch(Exception e3) {
>    			System.out.println("触发了Exception保护机制!");
>    			e3.printStackTrace();
>    		}
>    		finally {
>    			System.out.println("最后执行finally语法快");
>    		}
>    	}
>    	
>    	public void division(int a,int b) throws ArithmeticException {
>    		if(b==0) {
>    			throw new ArithmeticException();//主动抛出异常
>    		}
>    		else {
>    			System.out.println(a+" / "+b+" = "+a*1.0/b);
>    		}
>    	}
>    }
>    ```
>
>    ![try-catch-throws-finally](.\pictures\第十一章 异常机制\try-catch-throws-finally.png)



### JavaSE实例

> 1. 九九乘法表
>
>    ```java
>    //打印九九乘法口诀
>    package com.phc.examples;
>
>    public class Nine_to_nine_multiple {
>
>    	public static void main(String[] args) {
>    		// TODO Auto-generated method stub
>    		final int NINE=9;//常变量
>    		for(int i=1;i<=NINE;i++) {
>    			for(int j=1;j<=i;j++) {
>    				System.out.print(j+"X"+i+"="+(i*j)+"\t");
>    			}
>    			System.out.println();
>    		}
>    	}
>    }
>    ```
>
>    ![九九乘法表](.\pictures\JavaSE实例\九九乘法表.png)
>
> 2. 打印三角形
>
>    ```java
>    //打印三角形
>    package com.phc.examples;
>    import java.util.Scanner;
>
>    public class Triangle {
>    	public static void main(String[] args) {
>    		// TODO Auto-generated method stub
>    		System.out.print("请输入需要打印的三角形的行数:");
>    		Scanner in=new Scanner(System.in);
>    		final int num=in.nextInt();
>    		for(int i=1;i<=num;i++) {
>    			for(int j=num;j>i;j--) {
>    				//打印半倒三角的空格
>    				System.out.print(" ");
>    			}
>    			for(int k=1;k<=2*i-1;k++) {
>    				//每行打印2Xi-1个'*'
>    				System.out.print("*");
>    			}
>    			System.out.println();
>    		}
>    	}
>    }
>    ```
>
>    ![打印三角形](.\pictures\JavaSE实例\打印三角形.png "打印三角形")
>
> 3. 冒泡排序算法
>
>    ```java
>    //冒泡排序算法
>    package com.phc.sort_algorithm;
>    import java.util.Arrays;
>    import java.util.Scanner;
>
>    public class Bubble_sort_algorithm {
>
>    	public static void main(String[] args) {
>    		// TODO Auto-generated method stub
>    		Scanner in=new Scanner(System.in);
>    		System.out.print("请输入创建随机数组的大小(>0):");
>    		int arraySize=in.nextInt();
>    		int[] arrays=createRandomArrays(arraySize);
>    		System.out.println("数组元素为:");
>    		printArray(arrays);
>    		System.out.println("升序后的元素为:");
>    		bubble_sort_algorithm(arrays);
>    		printArray(arrays);
>    	}
>
>    	public static int[] createRandomArrays(int arraySize) {
>    		if(arraySize<=0) {
>    			System.out.println("数组大小不能小于或等于0");
>    			return null;
>    		}
>    		int[] arrays=new int[arraySize];
>    		for(int i=0;i<arrays.length;i++) {
>    			arrays[i]=(int) (Math.random()*100);
>    		}
>    		return arrays;
>    	}
>
>    	public static void printArray(int[] a) {
>    		for(int i=0;i<a.length;i++) {
>    			System.out.print(a[i]+" ");
>    		}
>    		System.out.println();
>    	}
>
>    	public static void bubble_sort_algorithm(int[] a) {
>    		boolean flag=true;//默认为已经排好序了
>    		for(int i=0;i<a.length;i++) {
>    			for(int j=a.length-1;j>i;j--) {
>    				if(a[j]<a[j-1]) {
>    					int temp=a[j];
>    					a[j]=a[j-1];
>    					a[j-1]=temp;
>    					flag=false;//只要进入了这个if语句，就说明没有排好序
>    				}
>    			}
>    			if(true==flag) {
>    				break;//说明里面已经排好序了，不需要再循环下去了，直接跳出
>    			}
>    		}
>    	}
>    }
>    ```
>
>    ![冒泡排序算法](.\pictures\JavaSE实例\冒泡排序算法.png "冒泡排序算法")
>
> 4. 稀疏矩阵的存储、转换
>
>    ```java
>    //稀疏矩阵的存储、转换
>    package com.phc.examples;
>    import java.util.Arrays;
>    import java.util.Scanner;
>          
>    public class Sparse_matrix {
>          
>    	public static void main(String[] args) {
>    		// TODO Auto-generated method stub
>    		System.out.println("Warning:该程序未进行容错处理!");
>    		Scanner in=new Scanner(System.in);
>    		System.out.print("请输入稀疏矩阵的行数:");
>    		final int row=in.nextInt();
>    		System.out.print("请输入稀疏矩阵的列数数:");
>    		final int col=in.nextInt();
>    		System.out.print("请输入稀疏矩阵的中元素的个数:");
>    		final int num=in.nextInt();
>    		int[][] sparseMatrix=createSparseMatrix(row,col,num);
>    		System.out.println("原始方法存储的稀疏矩阵:");
>    		printArrays(sparseMatrix);
>    		int[][] simpleMatrix=convertSimpleMatrix(sparseMatrix,num);
>    		System.out.println("压缩处理后存储的稀疏矩阵:");
>    		printArrays(simpleMatrix);
>    	}
>          
>    	public static int[][] createSparseMatrix(int row,int col,int num) {
>    		int[][] sparseMatrix=new int[row][col];
>    		//Arrays.fill(sparseMatrix, 0);
>    		//参数num组随机数
>    		int[] randomRows=new int[num];
>    		int[] randomCols=new int[num];
>    		for(int k=0;k<num;k++) {
>    			randomRows[k]=(int)(Math.random()*row);
>    			randomCols[k]=(int)(Math.random()*col);
>    		}
>    		for(int i=0;i<num;i++) {
>    			sparseMatrix[randomRows[i]][randomCols[i]]=(int)(Math.random()*100);
>    		}		
>    		return sparseMatrix;
>    	}
>          
>    	public static void printArrays(int[][] arrays) {
>    		for(int a1[]:arrays) {
>    			for(int a2:a1) {
>    				System.out.print(a2+"\t");
>    			}
>    			System.out.println();
>    		}
>    	}
>          
>    	public static int[][] convertSimpleMatrix(int[][] sparseMatrix,int num) {
>    		int row=sparseMatrix.length;
>    		int col=sparseMatrix[0].length;
>    		int[][] simpleMatrix=new int[num+1][3];
>    		simpleMatrix[0][0]=row;
>    		simpleMatrix[0][1]=col;
>    		simpleMatrix[0][2]=num;
>    		int count=1;
>    		for(int i=0;i<row;i++) {
>    			for(int j=0;j<col;j++) {
>    				if(sparseMatrix[i][j]!=0) {
>    					simpleMatrix[count][0]=i;
>    					simpleMatrix[count][1]=j;
>    					simpleMatrix[count][2]=sparseMatrix[i][j];
>    					count++;
>    				}
>    			}
>    		}
>    		return simpleMatrix;
>    	}
>    }
>    ```
>
>    ![稀疏矩阵](.\pictures\JavaSE实例\稀疏矩阵.png "稀疏矩阵")
>

