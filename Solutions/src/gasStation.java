
public class gasStation {
  /*
   * We traverse the whole array of gas, accumulating gas_left and gas_needed
   * Every time gas_left < 0, we restart it at 0 and move the starting point of the circuit to the next
   * At the end, if amount of gas needed <= gas we left, we are guaranteed to have a solution
   * and that solution is unique => we can return start
   * 
   * 
   * Proof: If sum of gas >= sum of cost, there exists a  unique solution 
   * 
   * If sum of all gas[i]-cost[i] is greater than or equal to 0, then there is a start position you can travel the whole circle.
Let i be the index such that the the partial sum

gas[0]-cost[0]+gas[1]-cost[1]+...+gas[i]-cost[i]
is the smallest, then the start position should be start=i+1 ( start=0 if i=n-1). Consider any other partial sum, for example,

gas[0]-cost[0]+gas[1]-cost[1]+...+gas[i]-cost[i]+gas[i+1]-cost[i+1]
Since gas[0]-cost[0]+gas[1]-cost[1]+...+gas[i]-cost[i] is the smallest, we must have

gas[i+1]-cost[i+1]>=0
in order for gas[0]-cost[0]+gas[1]-cost[1]+...+gas[i]-cost[i]+gas[i+1]-cost[i+1] to be greater.
The same reasoning gives that

 gas[i+1]-cost[i+1]>=0
 gas[i+1]-cost[i+1]+gas[i+2]-cost[i+2]>=0
 .......
 gas[i+1]-cost[i+1]+gas[i+2]-cost[i+2]+...+gas[n-1]-cost[n-1]>=0
What about for the partial sums that wraps around?

gas[0]-cost[0]+gas[1]-cost[1]+...+gas[j]-cost[j] + gas[i+1]-cost[i+1]+...+gas[n-1]-cost[n-1]
>=
gas[0]-cost[0]+gas[1]-cost[1]+...+gas[i]-cost[i] + gas[i+1]-cost[i+1]+...+gas[n-1]-cost[n-1]
>=0
The last inequality is due to the assumption that the entire sum of gas[k]-cost[k] is greater than or equal to 0.
So we have that all the partial sums

gas[i+1]-cost[i+1]>=0,
gas[i+1]-cost[i+1]+gas[i+2]-cost[i+2]>=0,
gas[i+1]-cost[i+1]+gas[i+2]-cost[i+2]+...+gas[n-1]-cost[n-1]>=0,
...
gas[i+1]-cost[i+1]+...+gas[n-1]-cost[n-1] + gas[0]-cost[0]+gas[1]-cost[1]+...+gas[j]-cost[j]>=0,
...
Thus i+1 is the position to start.
   */
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int gasLeft = 0;
    int gasNeeded = 0;
    int start = 0;
    for (int i = 0; i < gas.length; i++) {
      gasLeft = gasLeft + gas[i] - cost[i];
      if (gasLeft < 0) {
        gasNeeded = gasNeeded - gasLeft;
        start = i + 1;
        gasLeft = 0;
      }
    }

    if (gasLeft >= gasNeeded) {
      return start;
    } else
      return -1;
  }

}
