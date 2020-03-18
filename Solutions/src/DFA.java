
public class DFA {
  public static void main (String[] args) {
    
  }
  
  /*
   * Number      Current State
   * 0              q_0
   * 1              q_1,2
   * 3              q_3
   * 4              q_4
   * 5              q_5
   */
  public static int buildDFA(int currentState, char input) throws Exception {
    switch (currentState) {
      case 0: // if disconnected
        if (input == '1') { 
          // if move to connected
          return 1;
        } 
        break;
      case 1:  // if connected/author
        if (input == '3') { 
          // if switch role to reviewer
          return 3;
        } else if (input == '4') {
          // if switch to edit mode
          return 4;
        } else if (input == '6') {
          // disconnect
          return 0;
        }
        break;
      case 3:
        // if currently reviewer
        if (input == '6') {
          // disconnect
          return 0;
        } else if (input == '5') {
          // edit review
          return 5; 
        } else if (input == '2') {
          // switch to author
          return 1;
        }
        break;
      case 4:
       // if currently in edit mode
        if (input == '3') {
          // switch to reviewer
          return 3;
        } else if (input == '6') {
          return 0;
        } else if (input == '2') {
          return 1;
        }
        break;
      case 5:
       // if currently review mode
        if (input == '2') {
          return 1; 
        } else if (input == '6') {
          return 0;
        } else if (input == '3') {
          return 3;
        } 
        break;
    }
    throw new Exception ("Illegal move");
  }
 }
