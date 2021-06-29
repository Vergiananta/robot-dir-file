package com.Robot.Tugas9_Robot;

import java.awt.Robot;
import java.awt.image.SinglePixelPackedSampleModel;
import com.Robot.Tugas9_Robot.EnumRobot;
import com.Robot.Tugas9_Robot.Atribut_Robot;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
//mylogic = membuat if else untuk jalan robot.
//masing-masing num tersambung ke parent class Atribut_Robot.
public class MainRobot {
	static File file = new File("jejak_robot.txt");

	public static void main(String[] args) {
		try {
			
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String data = input.readLine();
			Atribut_Robot robot = fileRead();			
			System.out.println("Robot Position : "+ robot.toString());
			if(!(data).equals("E"));
				String[] commands = data.split("");
				for(String cmd : commands) {
					if(cmd.equals("L") || cmd.equals("R") || cmd.equals("F")) {
						String output = exCmd(cmd, robot);
						write(output);
					} else {
						System.out.println(cmd +"not right command");
					}
				}
			
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public static Atribut_Robot fileRead() {
		String txt1 = "";
		String txt2 = "";
		Atribut_Robot robot = null;
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			while(true) {
				txt1= bufferedReader.readLine();
				if(txt1 == null) {
					break;
				} else {
					txt2 = txt1;
					System.out.println(txt2);
				}
			}
			
			String[] parameter = parseLine(txt2);
			String param = parameter[2];
			
			
			EnumRobot compas = EnumRobot.valueOf(param);
			robot = new Atribut_Robot(Integer.parseInt(parameter[0]), Integer.parseInt(parameter[1]), compas);
			
			} catch(FileNotFoundException e) {
				e.getMessage();				
			} catch(IOException e) {
				e.getMessage();
			}
		
		return robot;
	}
	
	public static String[] parseLine(String txt2) {
		String a = txt2;
		String[] arr = a.split(",|-");
		return arr;
	}

	static String exCmd(String parameter, Atribut_Robot robot) {
		String cmd = parameter.toUpperCase();
		if(cmd.equals("F")) {		
			robot.forward();			
		} else if(cmd.equals("R")) {		
			robot.right();			
		} else if(cmd.equals("L")) {		
			robot.left();						
		}
		
		
		
		return robot.toString();
	}
	
		
	public static void write(String text) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
			bufferedWriter.newLine();
			bufferedWriter.append(text);
			bufferedWriter.close();
			System.out.println(text);			
		} catch(IOException e) {
			e.getMessage();
		}
	}
}

