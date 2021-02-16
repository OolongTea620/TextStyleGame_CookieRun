package s1;

public class Items {
	
	public int itemCode;//아이템 코드 
	public String name; //아이템의 명칭
	int give; // 점수를 얼마나 주는지?
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGive() {
		return give;
	}
	public void setGive(int give) {
		this.give = give;
	}
	
}
