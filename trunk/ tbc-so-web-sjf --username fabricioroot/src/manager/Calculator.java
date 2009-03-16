package manager;

import java.util.Vector;
import bean.Process;

/**
 *
 * @author Fabricio Reis
 */
public class Calculator {
    
    public Calculator() {
    }    

    /* This method calculates the waiting time and the turn around of the process that is going to be executed according
     * the algorithm SJF (shortest job first).
     */
    public Process waitingTimeAndTurnAround (Vector<Process> processes, int time, int maximum) {
        Process out = new Process();
        int aux = maximum + 1;
        int position = 0;
        
        // It finds the shortest burst time (life time)
        for(int i = 0; i <= (processes.size() - 1); i++) {
            if(aux > processes.elementAt(i).getLifeTime()) {
                aux = processes.elementAt(i).getLifeTime();
                position = i;
                if(aux == 1) {
                    i = processes.size();
                }
            }
        }        
        out = processes.elementAt(position);
        // Waiting time = time (clock) - creation time
        out.setWaitingTime(time - out.getCreationTime());
        // Turn Around = waiting time + burst time
        out.setTurnAround(out.getWaitingTime() + out.getLifeTime());
        return out;
    }
    
    
    /* This method calculates the average of the waiting times.
     */
    public int averageWaitingTime (Vector<Process> processes) {
        int aux = 0;
        for (int i = 0; i <= (processes.size() - 1); i++) {
            aux += processes.elementAt(i).getWaitingTime();
        }
        aux = aux / processes.size();
        return aux;
    }
    
    /* This method calculates the average of the turns around.
     */
    public int averageTurnAround (Vector<Process> processes) {
        int aux = 0;
        for (int i = 0; i <= (processes.size() - 1); i++) {
            aux += processes.elementAt(i).getTurnAround();
        }
        aux = aux / processes.size();
        return aux;
    }
}