public class Sudoku {
    public static void main(String[] args) {
        int[][] board={
            {1,3,0,7,0,2,0,0,9},
            {0,0,0,1,0,0,0,0,3},
            {0,0,6,0,0,0,2,0,0},
            {4,0,0,0,5,0,0,8,6},
            {0,0,0,8,0,1,0,0,0},
            {2,5,0,0,9,0,0,0,7},
            {0,0,9,0,0,0,8,0,0},
            {7,0,0,0,0,8,0,0,0},
            {5,0,0,9,0,6,0,3,2}
        }; 
        if(solve(board)){
            display(board);
        }
        else{System.out.println("cannot solve");}
    }
    static boolean solve(int[][] board){
        int n=board.length;
        int row=-1;
        int col=-1;
        boolean empty=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0){
                    row=i;
                    col=j;
                    empty=false;
                    break;
                }
            }
            //if u found some empty element in row,break;
            if(empty==false){
                break;
            }
        }
        if(empty==true){
            return true;
            //sudoku solved
        }
        for(int number=1;number<=9;number++){
            if(isSafe(board, row, col, number)){
                board[row][col]=number;
                if(solve(board)){
                    //found the ans
                    return true;
                }
                else{board[row][col]=0;}
            }
        }
        return false;
    }
    static boolean isSafe(int[][] board ,int row ,int col,int num){
        //check in row
        for(int i=0;i<board.length;i++){
            if(board[row][i]==num){
                return false;
            }
        }
        //check in column
        for(int[] nums:board){
            if(nums[col]==num){
                return false;
            }
        }
        int sqrt=(int)(Math.sqrt(board.length));
        int rowstart=row-(row%sqrt);
        int colstart=col-(col%sqrt);
        for(int r=rowstart;r<(rowstart+sqrt);r++){
            for(int c=colstart;c<(colstart+sqrt);c++){
                if(board[r][c]==num){
                    return false;
                }
            }
        }
        return true;
    }
    static void display(int[][] board){
        for(int[] row:board){
            for(int num:row){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}
