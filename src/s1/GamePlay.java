package s1;
import java.util.Random;
import java.util.Scanner;
public class GamePlay {
	
	public static void main(String[] args) {
		System.out.println("게임이 시작되었다!");
		Scanner sc = new Scanner(System.in);
		
		//경기장 셋팅
		//1. 아이템코드 생성
		
		GameManager gm = new GameManager(); //게임 매니져 생성
		System.out.println("심판을 데려왔다");
		
		//쿠키입장
		Cookie ck = new Cookie(); 
		ck.setHp(20);//쿠키의 체력은 50이다
		System.out.println("쿠키 입장!");
		
		boolean playing = true;
		int randomcode;
		int cookieAct;
		
		while(playing){
			
			//1. 장애물혹은 코드를 랜덤으로 돌린다 
			randomcode = gm.giveRandom();
			//1-1. 랜덤에 걸맞는 상황이 텍스트로 나온다.(심판이 할 일)
			gm.sayState(randomcode);
			//2. 쿠키의 행동을 묻는다
			System.out.println("쿠키는 무엇을 할까?");
			System.out.println("1.점프 2. 먹기 그외.지나치기 ");
			cookieAct = sc.nextInt();
			//3. 상황에 맞는 행동판정을 한다
			
			ck.setHp(ck.getHp() + gm.doingJudge(randomcode,cookieAct));
			System.out.println("현재 HP: " + ck.getHp());
			
			if(ck.getHp() < 0) {
				System.out.println("게임 종료!");
				//점수 출력
				gm.sayScore();
				playing = false;
				break;//루프탈출
			}else {
				//5.hp를 1깎는다.
				ck.setHp(ck.getHp() - 1);
			}
			
		}
		gm.sayScore(); // 점수 출력!
		System.out.println("게임종료!");
		
	}
	
	
}
