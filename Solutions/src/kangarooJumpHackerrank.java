
public class kangarooJumpHackerrank {
  static String kangaroo(int x1, int v1, int x2, int v2) {
    if (x2 > x1 && v2 >= v1) {
        return "NO";
    } 

    int initDist = x2 - x1; // always > 0
    int speedDif = v1 - v2;
    if (initDist % speedDif == 0) {
        return "YES";
    }

    return "NO";

}
}
