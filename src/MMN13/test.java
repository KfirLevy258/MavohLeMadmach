package MMN13;

public class test {
	public static void main(String[] args) {
//		int[][] a = {{1, 6}, {3, 4, 5, 4, 6}, {},{1}};
//		int[][] b = new int[3][3];

//		for (int i =0; i<3; i++) {
//			for (int j=0; j<3; j++) {
//				System.out.println(b[i][j]);
//			}
//		}
		int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

//
		Square3x3 sq = new Square3x3(a);
		System.out.println(sq.toString());
		System.out.println(sq.allThere());
//		boolean[] x = new boolean[]{false, false, false, false, false, false, false, false, false, true};
//		sq.whosThereCol(1, x);
//		for (int i=0; i<x.length; i++) {
//			System.out.println(x[i]);
//		}
//		sq.whosThereCol(4, new boolean[]{false, false, false, false, false, false, false, false, false, false});
//		Square3x3[][] aa = {
//				{new Square3x3(new int[][]{{1, 9, 8}, {7, 3, 2}, {5, 6, 4}}),
//						new Square3x3(new int[][]{{6, 2, 3}, {9, 5, 4}, {8, 1, 7}}),
//						new Square3x3(new int[][]{{4, 5, 7}, {1, 8, 9}, {2, 3, 6}})},
//				{new Square3x3(new int[][]{{3, 1, 9}, {8, 4, 7}, {2, 5, 6}}),
//						new Square3x3(new int[][]{{2, 8, 5}, {1, 3, 6}, {4, 7, 9}}),
//						new Square3x3(new int[][]{{7, 6, 4}, {5, 9, 2}, {8, 1, 3}})},
//				{new Square3x3(new int[][]{{4, 8, 5}, {6, 2, 1}, {9, 7, 3}}),
//						new Square3x3(new int[][]{{3, 6, 2}, {7, 9, 8}, {5, 4, 1}}),
//						new Square3x3(new int[][]{{9, 7, 1}, {3, 4, 5}, {6, 2, 8}})},
//		};
////		System.out.println(sq.toString());
////		System.out.println(sq.allThere());
//		Sudoku s = new Sudoku(aa);
////		Square3x3[] arr = new Square3x3[]{
////				new Square3x3(new int[][]{{3, 1, 9}, {8, 4, 7}, {2, 5, 6}}),
////				new Square3x3(new int[][]{{2, 8, 5}, {1, 3, 6}, {4, 7, 9}}),
////				new Square3x3(new int[][]{{7, 6, 4}, {5, 9, 2}, {8, 1, 3}})
////		};
////		boolean[] b = new boolean[]{false, false, false, false, false, false, false, false, false, false};
////		for (int i=0; i<arr.length; i++){
////			arr[i].whosThereRow(0, b);
////		}
////		for (int i=0; i<b.length; i++){
////			System.out.println(b[i]);
////		}
////		System.out.println(b);
//		System.out.println(s.isValid());

	}

}
