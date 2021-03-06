import java.util.ArrayList;
public class Rook implements Figur {

    private String token = "T";
    private boolean iswhite;
    private boolean hasmoved;
    private int figurid;
    static int id = 0;

    public Rook(boolean iswhite){
        this.hasmoved = false;
        this.iswhite = iswhite;
        this.figurid = id;
        id += 1;
    }
    public String getToken() {
        return token;
    }

    public boolean iswhite() {
        return iswhite;
    }

    public boolean islegal(int[] array){
        if(array[0] != array[2] && array[1] != array[3] ) {
            return false;
        }
        return true;
    }
    public void setHasMoved(boolean setHasMoved){
        hasmoved = setHasMoved;
    }

    public boolean getHasmoved() {
        return hasmoved;
    }

    public ArrayList<Integer> path(int[] array) {
        ArrayList<Integer> path = new ArrayList<>();
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
        return path;
    }
}
