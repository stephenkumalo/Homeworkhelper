package helper;
import java.awt.List;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Hmwrk {
Document mathhmwrk;
ArrayList<Homework> homework = new ArrayList<Homework>();
public Hmwrk() throws IOException{
	mathhmwrk = Jsoup.connect("http://www.math.ttu.edu/~xiwang/3310/3310hw.html").get();	
}
public Homework getRecent(){
	Homework recent = null;
	for(Homework temp : homework){
		if(recent == null || recent.getProblemNumber() < temp.getProblemNumber()){
			recent  =  temp;
		}
	}
	return recent;
}
public void getAll() throws ParseException{
	Elements tableparser = mathhmwrk.getElementsByTag("tr");
	for(Element tableRow : tableparser){
		java.util.List<Element> temp = tableRow.children();
		Homework hw = new Homework();
		if(temp.get(0).text().trim().matches("[0-9]+")){
			hw.setProblemNumber(Integer.parseInt(temp.get(0).text().trim()));
			hw.setHomeworkInfo(temp.get(1).text().trim());
			
			hw.setPoints(Integer.parseInt(temp.get(2).text().trim()));
			Calendar cal = Calendar.getInstance(), calPre = Calendar.getInstance();
			String [] val1 = temp.get(3).text().trim().split("/");
			calPre.set(Integer.parseInt(val1[2])+2000,Integer.parseInt(val1[0])-1, Integer.parseInt(val1[1]), 12, 30);
			hw.setHomeworkRoughDraft(calPre.getTime());
			
			String [] val = temp.get(4).text().trim().split("/");
			cal.set(Integer.parseInt(val[2])+2000,Integer.parseInt(val[0])-1, Integer.parseInt(val[1]), 12, 30);
			hw.setHomeworkDueDate(cal.getTime());
		
		this.homework.add(hw);
		}
	}
}
}
