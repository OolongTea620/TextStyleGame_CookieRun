package s1;

import java.util.Random;

public class GameManager {

	
	private int score; //쿠키게임 점수 매기는 역활
	
	private int eatJelly; //먹은 젤리의 갯수;
	
	
	Candy cd ;
	
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getEatJelly() {
		return eatJelly;
	}

	public void setEatJelly(int eatJelly) {
		this.eatJelly = eatJelly;
	}
	
	public int giveRandom() {
		Random random = new Random();
		
		int rannum = random.nextInt()%4;
		
		return rannum;
	}
	
	void sayScore() {
		System.out.println("쿠키가 얻은 점수는 "+ this.score+" 점 입니다");
	}
	void sayState(int ss) {
		String name = null;
		switch(ss) {
		case 0: name = "사탕";
			break;
		case 1: 
			name = "젤리";
			break; 
		case 2: 
			name = "물약";
			break;
			
		case 3: 
			name = "장애물";
			break;
		default : name = "사탕";
			
		}
		System.out.println("쿠키앞에 "+ name +" 가 있다...");
	}
	int doingJudge(int icode , int ccode) { //심판님 판단 좀 해봐요...
		
		
		int hp =0;
		
		if(icode == 0 &&ccode == 2) { // 사탕+ 먹기 > 점수 5점
			System.out.println("쿠키는 사탕을 먹었다!");
			score = score+5;
			
		}else if(icode == 1 &&ccode == 2) { //젤리 + 먹기 > 3개면 100점 주고 다시 0으로 카운트해
			if(eatJelly == 2) 
			{
				score = score+100;
				eatJelly = 0;
			}
			System.out.println("쿠키는 젤리를 먹었다! 현재: " +(eatJelly+1) +"개");
			eatJelly++ ;
			
		}else if(icode == 2 && ccode == 2) { // 물약 먹기 > hp 10증가
			System.out.println("쿠키는 물약을 먹었다!");
			hp = 10;
		}else if(icode == 3 && ccode == 3) { // 장애물 지나치기 > hp 10감소
			System.out.println("쿠키는 실수를 했다!");
			hp = -10;
		}else if(icode == 3 && ccode == 3) { // 장애물 먹기 > 실수, hp 10감소
			System.out.println("쿠키는 실수를 했다!");
			hp = -10;
		}
		
		return hp;
		
	}
	
}
