package xyz.vjudge.contest341484;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class ProblemA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N, inIndex, priority, doctorNum;

        String type;
        Doctor doctor1 = new Doctor(1);
        Doctor doctor2 = new Doctor(2);
        Doctor doctor3 = new Doctor(3);
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(doctor1);
        doctors.add(doctor2);
        doctors.add(doctor3);

        while (in.hasNext()) {
            N = in.nextInt();
            System.out.println(N);
            inIndex = 1;
            for (int i = 0; i < N; i++) {
                type = in.next();
                System.out.println(type);
                if (type.equals("IN")) {
                    doctorNum = in.nextInt();
                    priority = in.nextInt();
                    Patient patient = new Patient(inIndex, 11 - priority);
                    inIndex++;
                    doctors.get(doctorNum).getQueue().add(patient);
                } else {
                    doctorNum = in.nextInt();
                    if (doctors.get(doctorNum).getQueue().isEmpty()) {
                        System.out.println("EMPTY");
                    } else {
                        System.out.println(doctors.get(doctorNum).getQueue().poll().getId());
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                doctors.get(i).getQueue().clear();
            }
        }
    }

    static class Doctor {
        private int id;
        private PriorityQueue<Patient> queue = new PriorityQueue<>((p1, p2) -> {
            if (p1.priority == p2.priority) {
                return p1.id - p2.id;
            } else {
                return p1.priority - p2.priority;
            }
        });

        public Doctor(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public PriorityQueue<Patient> getQueue() {
            return queue;
        }
    }

    static class Patient {
        private int priority;
        private int id;

        public Patient(int id, int priority) {
            this.priority = priority;
            this.id = id;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
