import java.util.ArrayList;
public class Queen implements Figur {

    private String token = "Q";
    private boolean iswhite;
    private int figurid;
    static int id = 0;

    public Queen(boolean iswhite){
        this.iswhite = iswhite;
        this.figurid = id;
        id += 1;
    }

    public boolean iswhite() {
        return iswhite;
    }

    @Override
    public String getToken() {
        return token;
    }

    //array 0 = array[0], 1 = array[1], 2 = array[2], 3 = array[3]
    public boolean islegal(int []array){

        if(array[0] != array[2] && array[1] != array[3] ) {
            if(Math.abs(array[0] - array[2])!= Math.abs(array[1] - array[3])){
                return false;
            } }
        return true;
    }

    //path ist ohne start und end punkt, alle felder die von der Figur beschritten werden.
    public  ArrayList<Integer> path(int[] array){
        ArrayList<Integer> path = new ArrayList<>();
        if(array[0] != array[2] && array[1] != array[3]) {   //same code in Bishop
            int x = array[2] - array[0];
            int y = array[3] - array[1];
            if (x > 0 && y > 0) {
                for (int i = 1; i < x; i++) {
                    path.add(array[0] + i);
                    path.add(array[1] + i);
                }
            } else if (x < 0 && y < 0) {
                for (int i = -1; i > x; i--) {
                    path.add(array[0] + i);
                    path.add(array[1] + i);
                }
            } else if (x > 0 && y < 0) {
                for (int i = 1; i < x; i++) {
                    path.add(array[0] + i);
                    path.add(array[1] - i);
                }
            } else {
                for (int i = -1; i > x; i--) {
                    path.add(array[0] + i);
                    path.add(array[1] - i);
                }
            }
        }
        else{
            if(array[0]!= array[2]){
                int x =  array[2]-array[0];
                if(x > 0){
                    for(int i=1; i < x; i++ ){
                        path.add(array[0]+i);
                        path.add(array[1]);
                    }}
                else{
                    for(int i=-1; i > x; i-- ){
                        path.add(array[0]+i);
                        path.add(array[1]);
                    }}
            }
            else{
                int y =  array[3]-array[1];
                if(y > 0){
                    for(int i=1; i < y; i++ ){
                        path.add(array[0]);
                        path.add(array[1]+i);
                    }}
                else{
                    for(int i=-1; i > y; i-- ){
                        path.add(array[0]);
                        path.add(array[1]+i);
                    }}
            }
        }
        return path;
        }

}
