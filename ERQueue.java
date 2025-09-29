import java.util.PriorityQueue;

public class ERQueue{
	class Patient  implements Comparable<Patient>{
		String name;
		int priority;
		String condition;
		String arrivalTime;	
		
		Patient(String name, int priority, String condition, String arrivalTime) {
			this.name = name;
			this.priority = priority;
			this.condition = condition;
			this.arrivalTime = arrivalTime;
		}
		
		@Override
		public String toString() {
			return "[P" + priority + "] " + name  + " - " + condition + " - " + arrivalTime;
		}

		@Override
		public int compareTo(ERQueue.Patient o) {
			if(this.priority != o.priority) {
				return Integer.compare(this.priority, o.priority);
			}
			return this.arrivalTime.compareTo(o.arrivalTime);
		}
	}
	
	PriorityQueue<Patient> p = new PriorityQueue<>();
	
	void arrive(String name, int priority, String condition, String time) {
		Patient patient = new Patient(name, priority, condition, time);
		p.add(patient);
	}
	
	void treatNext() {
		System.out.println(">>> Treating patient now...");
		System.out.println("Treated: " + p.peek());
		System.out.println("");
		p.remove();
	}
	
	void displayQueue() {
		System.out.println("=== UPDATED QUEUE===");
		System.out.println("Patients Waiting: " + p.size());
		for(Patient p: p) {
			System.out.println(p);
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		ERQueue er = new ERQueue();
		 
		er.arrive("Pedro Cruz", 1, "Head injury - NOW UNCONSCIOUS ⚠️", "23:52");
		er.arrive("Carlos Mendoza", 2, "Compound fracture - leg", "23:50");
		er.arrive("Lisa Wang", 2, "Severe asthma attack", "23:56");
		er.arrive("Maria Santos", 3, "Deep laceration on arm", "23:48");
		er.arrive("Ana Lim", 4, "Sprained ankle", "23:49");
		 
		er.displayQueue();
		er.treatNext();
		er.displayQueue();
	}
}

