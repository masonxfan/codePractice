package questions;

public class math1041RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int[] movex = {0, 1, 0, -1};
        int[] movey = {1, 0, -1, 0};
        int directory = 0;
        int rnd = 0;
        int[] v = {0, 0};
        for(int i = 0; i < instructions.length(); i++){
            if(instructions.charAt(i) == 'G'){
                v[0] += movex[directory];
                v[1] += movey[directory];
            }else if(instructions.charAt(i) == 'L'){
                directory--;
                directory = (directory + 4) % 4;
            }else{
                directory++;
                directory = (directory + 4) % 4;
            }
        }
        if(v[1] == v[0] && v[0] == 0) return true;
        if(directory != 0) return true;
        return false;
    }
}
