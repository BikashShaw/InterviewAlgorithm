package complex.algo.square;

import java.util.*;

public class StudentTeacherClassRoom {

    public static void main(String[] args) {
        List<String> teachers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            teachers.add("Teacher_" + i);
        }

        List<String> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add("Student_" + i);
        }

        System.out.println(assignment(teachers, students));

    }

    public static Map<String, List<String>> assignment(List<String> teachers, List<String> students) {
        int totalTeachers = teachers.size();
        int totalStudents = students.size();
        int maxStudentPerClass = totalStudents / totalTeachers;
        int extraStudent = totalStudents % totalTeachers;
        Map<String, List<String>> map = new HashMap<>();

        Iterator<String> iterator = students.iterator();
        for (String teacher : teachers) {
            List<String> slist = new ArrayList<>();

            int thisTeacherStudentCount = maxStudentPerClass;

            if (extraStudent > 0) {
                extraStudent--;
                thisTeacherStudentCount++;
            }
            while (iterator.hasNext()) {
                if (slist.size() == thisTeacherStudentCount) {
                    break;
                }
                slist.add(iterator.next());

                map.put(teacher, slist);
            }
        }

        return map;
    }
}
