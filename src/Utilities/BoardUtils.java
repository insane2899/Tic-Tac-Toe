package Utilities;

public final class BoardUtils {
	
	public static final int NUM_TILE = 9;
	public static final int NUM_ROW = 3;
	public static final boolean[] FIRST_ROW = getRow(0);
	public static final boolean[] SECOND_ROW = getRow(3);
	public static final boolean[] THIRD_ROW = getRow(6);
	
	public static final boolean[] FIRST_COLUMN = getCol(0);
	public static final boolean[] SECOND_COLUMN = getCol(1);
	public static final boolean[] THIRD_COLUMN = getCol(2);
	
	private BoardUtils() {}
	
	private static boolean[] getRow(int i) {
		boolean[] ans = new boolean[NUM_TILE];
		for(int index = i;index<i+NUM_ROW;index++) {
			ans[index]=true;
		}
		return ans;
	}
	
	private static boolean[] getCol(int i) {
		boolean[] ans = new boolean[NUM_TILE];
		for(int index=i;index<NUM_TILE;index+=3) {
			ans[index]=true;
		}
		return ans;
	}
}
