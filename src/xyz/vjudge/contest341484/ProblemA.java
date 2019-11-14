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

/*
* 记录一下修bug的过程
* in.nextInt()函数要有一个结束符才会开始读取（空白符比如换行）否则会一直等着觉得没有输入完，表现出来的结果就是一直在等待输入
* 在这里最后一个数字后面由于没有终止符，因此in认为还有输入没有输完，因此没有读取最后一个数据
* 但是文件结束符也是结束符，因此wrong answer不是由于输入原因造成的（实际上输入时没问题的）
* wrong answer是由于医生的id没有从1开始，因此在id=3的医生时越界了。。。
* */
        while (in.hasNext()) {
            N = in.nextInt();
            inIndex = 1;
            for (int i = 0; i < N; i++) {
                type = in.next();
                if (type.equals("IN")) {
                    doctorNum = in.nextInt();
                    priority = in.nextInt();
                    Patient patient = new Patient(inIndex, 11 - priority);
                    inIndex++;
                    doctors.get(doctorNum - 1).getQueue().add(patient);
                } else {
                    doctorNum = in.nextInt();
                    if (doctors.get(doctorNum - 1).getQueue().isEmpty()) {
                        System.out.println("EMPTY");
                    } else {
                        System.out.println(doctors.get(doctorNum - 1).getQueue().poll().getId());
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
