package kh.model.vo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



class Food implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private int kcal;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public Food() {
		name = "";
		kcal = 0;
	}
	
	public Food(String name, int kcal) {
		this.name = name;
		this.kcal = kcal;
	}
	@Override
	public String toString() {
		return "이름 : " + name + ", 칼로리 : " + kcal;
	}
	
	public void fileSave(String fileName) {
		Food food = new Food("사과", 20);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(food);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
