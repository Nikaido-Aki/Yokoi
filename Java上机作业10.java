package homework_10;


import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin=new Scanner(System.in);
		String address=null;
		System.out.println("请输入文件名和路径");
		address=cin.next();
		java.io.File file=new java.io.File(address);
		Scanner input=new Scanner(file);
		String line=null;
		int num_line=0,num_space=0,num_str=0;
		int[] chara_num=new int[105];
		while(input.hasNext())
		{
			line=input.nextLine();
			++num_line;
			char[] cline=line.toCharArray();
			for(int i=0;i<line.length();++i)
			{
				if(cline[i]>='a'&&cline[i]<='z') ++chara_num[(int)cline[i]-97];
				else if(cline[i]>='A'&&cline[i]<='Z') ++chara_num[(int)cline[i]-65];
				else if(cline[i]==' ') ++num_space;
				++num_str;
			}
		}
		//System.out.println("空格："+num_space);
		System.out.println("本文共"+num_line+"行，"+(num_space+num_line)+"个单词，"+num_str+"个字符。");
		System.out.println("请选择需要查询的字母：（不区分大小写）");
		while(cin.hasNext())
		{
			try
			{
				String mida=cin.next();
				char reala=mida.charAt(0);
				if(reala>='A'&&reala<='Z') System.out.println("出现了"+chara_num[(int)reala-65]+"次");
				else if(reala>='a'&&reala<='z') System.out.println("出现了"+chara_num[(int)reala-97]+"次");
				else throw new Exception();
			} 
			catch(Exception e)
			{
				System.out.println("Error!请重新输入！");
			}
		}
	}
}