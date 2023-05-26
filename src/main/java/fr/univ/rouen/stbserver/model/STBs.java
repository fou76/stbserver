package fr.univ.rouen.stbserver.model;

import java.io.Serializable;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;

public class STBs implements Serializable{
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "stb")
	private List<STB> stbs;
	
	public STBs() {
		
	}

	public STBs(List<STB> list) {
		this.stbs = list;
	}
	
	@Override
	public String toString() {
		String string = "";
		for (STB STB : stbs) {
			string =  STB.toString() + "\n";
		}
		return string;
	}
	
	
	public List<STB> getStbs() {
		return stbs;
	}

	public void setStbs(List<STB> stbs) {
		this.stbs = stbs;
	}

}
