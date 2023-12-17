public class TowerOfHanoiAlgo extends DsaBaseClass {
  /*
   * *********************
   * It is a mathematical puzzle that involves 3 rods and n disks of different
   * size
   * Puzzle begins with the following state
   * One rod has all the disks stacked one above the other in descending order
   * The game is about solving the puzzle such that all the disks are arranged
   * in a different rod at the same time
   * The rule to be followed are
   * 1. Only one disk can be moved at time
   * 2. Larger disk cannot be stack above a smalles disk
   * 
   * For example move from tower A to tower B
   */

  @Override
  public void excercise() {
    int nDisk = 3;
    shiftDisk(nDisk, 'A', 'B', 'C');
  }

  void shiftDisk(int nDisk, char tA, char tB, char tC) {
    if (nDisk == 1) {
      System.out.println("Disk " + nDisk + " is shifted from " + tA + " to " + tB);
    } else {
      shiftDisk(nDisk - 1, tA, tC, tB);
      System.out.println("Disk " + nDisk + " from " + tA + " shifted to " + tB);
      shiftDisk(nDisk - 1, tC, tB, tA);
    }
  }
}
