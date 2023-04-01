package step12_jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JsoupTest {

	public static void main(String[] args) {
		Document doc = null;
		
		try {
			doc = Jsoup.connect("https://sports.news.naver.com/wfootball/index.nhn").get();
			System.out.println(doc.title());
			System.out.println();
			System.out.println();
			System.out.println("오늘의 EPL 순위는");
			System.out.println();
			System.out.println(doc.select("#_team_rank_epl > table > thead").text());
			System.out.println("----------------------------------------------");

			
			for(int i = 1; i < 11; i++) {
				Elements el = doc.select("#_team_rank_epl > table > tbody > tr:nth-child(" + i + ")");
				System.out.println(el.text());
				if (el.text().contains("리버풀")
						&&(el.text().contains("1위")
						|| (el.text().contains("2위")
						|| el.text().contains("3위")))) {
					System.out.println("-->얘가 왜 여기에 있어?");
				} else if(el.text().contains("리버풀"))
						{System.out.println("-->리중딱!!");}
//				System.out.println("");
				System.out.println("-------------------------------------------");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
