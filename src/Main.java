
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // إنشاء الكلية
        College college = new College();
        Scanner scanner = new Scanner(System.in);

        System.out.println("مرحبًا بكم في الجامعة!");

        // القائمة الرئيسية
        while (true) {
            System.out.println("\nالعمليات:");
            System.out.println("1- الكلية");
            System.out.println("2- القسم");
            System.out.println("3- الدورة");
            System.out.println("4- الأستاذ");
            System.out.println("5- الطالب");
            System.out.println("6- إنهاء");
            System.out.print("اختر عملية: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // لتجنب مشاكل قراءة النصوص بعد الأرقام

            switch (choice) {
                case 1:
                    handleCollegeOperations(college, scanner);
                    break;
                case 2:
                    handleDepartmentOperations(college, scanner);
                    break;
                case 3:
                    handleCourseOperations(college, scanner);
                    break;
                case 4:
                    handleProfessorOperations(college, scanner);
                    break;
                case 5:
                    handleStudentOperations(college, scanner);
                    break;
                case 6:
                    System.out.println("تم إنهاء البرنامج. شكرًا لاستخدامك النظام!");
                    return;
                default:
                    System.out.println("خيار غير صحيح. حاول مرة أخرى.");
            }
        }
    }

    // التعامل مع عمليات الكلية
    private static void handleCollegeOperations(College college, Scanner scanner) {
        System.out.println("\nعمليات الكلية:");
        System.out.println("a) عدد الأقسام");
        System.out.println("b) عدد الدورات");
        System.out.println("c) عدد الأساتذة");
        System.out.println("d) عدد الطلاب");
        System.out.println("e) تقرير");
        System.out.print("اختر عملية: ");

        String option = scanner.nextLine();

        switch (option) {
            case "a":
                System.out.println("عدد الأقسام: " + college.numberOfDepartments());
                break;
            case "b":
                System.out.println("عدد الدورات: " + college.numberOfCourses());
                break;
            case "c":
                System.out.println("عدد الأساتذة: " + college.numberOfProfessors());
                break;
            case "d":
                System.out.println("عدد الطلاب: " + college.numberOfStudents());
                break;
            case "e":
                System.out.println("تقرير الكلية:");
                System.out.println("عدد الأقسام: " + college.numberOfDepartments());
                System.out.println("عدد الدورات: " + college.numberOfCourses());
                System.out.println("عدد الأساتذة: " + college.numberOfProfessors());
                System.out.println("عدد الطلاب: " + college.numberOfStudents());
                break;
            default:
                System.out.println("خيار غير صحيح.");
        }
    }

    // التعامل مع عمليات الأقسام
    private static void handleDepartmentOperations(College college, Scanner scanner) {
        System.out.println("\nعمليات القسم:");
        System.out.println("a) إنشاء قسم جديد");
        System.out.println("b) عدد الدورات");
        System.out.println("c) عدد الطلاب");
        System.out.println("d) هل القسم ممتلئ؟");
        System.out.println("e) تسجيل طالب");
        System.out.println("f) تقرير");
        System.out.print("اختر عملية: ");

        String option = scanner.nextLine();

        switch (option) {
            case "a": // إنشاء قسم جديد
                System.out.print("اسم القسم: ");
                String departmentName = scanner.nextLine();
                System.out.print("وصف القسم: ");
                String departmentDescription = scanner.nextLine();
                System.out.print("الحد الأقصى للطلاب: ");
                int maxStudents = scanner.nextInt();
                scanner.nextLine();
                Departments newDepartment = new Departments(departmentName, departmentDescription, maxStudents);
                college.addDepartment(newDepartment);
                System.out.println("تم إنشاء القسم بنجاح.");
                break;

            case "b": // عدد الدورات
                System.out.print("اسم القسم: ");
                String deptName = scanner.nextLine();
                Departments department = college.findDepartment(deptName);
                if (department != null) {
                    System.out.println("عدد الدورات في القسم: " + department.numberOfCourses());
                } else {
                    System.out.println("القسم غير موجود.");
                }
                break;

            case "c": // عدد الطلاب
                System.out.print("اسم القسم: ");
                deptName = scanner.nextLine();
                department = college.findDepartment(deptName);
                if (department != null) {
                    System.out.println("عدد الطلاب في القسم: " + department.numberOfStudents());
                } else {
                    System.out.println("القسم غير موجود.");
                }
                break;

            case "d": // هل القسم ممتلئ؟
                System.out.print("اسم القسم: ");
                deptName = scanner.nextLine();
                department = college.findDepartment(deptName);
                if (department != null) {
                    System.out.println("القسم ممتلئ؟ " + (department.isFull() ? "نعم" : "لا"));
                } else {
                    System.out.println("القسم غير موجود.");
                }
                break;

            case "e": // تسجيل طالب
                System.out.print("اسم القسم: ");
                deptName = scanner.nextLine();
                department = college.findDepartment(deptName);
                if (department != null) {
                    System.out.print("اسم الطالب الكامل: ");
                    String studentName = scanner.nextLine();
                    Students student = college.findStudent(studentName);
                    if (student != null) {
                        if (department.enroll(student)) {
                            System.out.println("تم تسجيل الطالب بنجاح.");
                        } else {
                            System.out.println("القسم ممتلئ أو الطالب مسجل بالفعل.");
                        }
                    } else {
                        System.out.println("الطالب غير موجود.");
                    }
                } else {
                    System.out.println("القسم غير موجود.");
                }
                break;

            case "f": // تقرير القسم
                System.out.print("اسم القسم: ");
                deptName = scanner.nextLine();
                department = college.findDepartment(deptName);
                if (department != null) {
                    System.out.println("تقرير القسم:");
                    System.out.println("الوصف: " + department.getName());
                    System.out.println("الحد الأقصى للطلاب: " + department.getStudents());
                    System.out.println("عدد الطلاب: " + department.numberOfStudents());
                    System.out.println("عدد الدورات: " + department.numberOfCourses());
                    System.out.println("القسم ممتلئ؟ " + (department.isFull() ? "نعم" : "لا"));
                } else {
                    System.out.println("القسم غير موجود.");
                }
                break;

            default:
                System.out.println("خيار غير صحيح.");
        }
    }

    // التعامل مع عمليات الدورات
    private static void handleCourseOperations(College college, Scanner scanner) {
        System.out.println("\nعمليات الدورة:");
        System.out.println("a) إنشاء دورة جديدة");
        System.out.println("b) عدد الطلاب في الدورة");
        System.out.println("c) تعيين أستاذ");
        System.out.println("d) هل الدورة تحتوي على أستاذ؟");
        System.out.println("e) اسم الأستاذ المعين");
        System.out.println("f) هل الدورة ممتلئة؟");
        System.out.println("g) تسجيل طالب في الدورة");
        System.out.println("h) تقرير");
        System.out.print("اختر عملية: ");

        String option = scanner.nextLine();

        switch (option) {
            case "a": // إنشاء دورة جديدة
                System.out.print("اسم الدورة: ");
                String courseName = scanner.nextLine();
                System.out.print("وصف الدورة: ");
                String courseDescription = scanner.nextLine();
                System.out.print("الحد الأقصى للطلاب: ");
                int maxStudents = scanner.nextInt();
                System.out.print("عدد المحاضرات: ");
                int numberOfLectures = scanner.nextInt();
                scanner.nextLine();
                System.out.print("اسم القسم المرتبط: ");
                String departmentName = scanner.nextLine();
                Departments department = college.findDepartment(departmentName);

                if (department != null) {
                    Courses newCourse = new Courses(courseName, courseDescription, maxStudents, numberOfLectures, department);
                    department.getCourses().add(newCourse);
                    college.addCourse(newCourse);
                    System.out.println("تم إنشاء الدورة بنجاح.");
                } else {
                    System.out.println("القسم غير موجود.");
                }
                break;

            case "b": // عدد الطلاب في الدورة
                System.out.print("اسم الدورة: ");
                courseName = scanner.nextLine();
                Courses course = college.findCourse(courseName);
                if (course != null) {
                    System.out.println("عدد الطلاب في الدورة: " + course.numberOfStudents());
                } else {
                    System.out.println("الدورة غير موجودة.");
                }
                break;

            case "c": // تعيين أستاذ
                System.out.print("اسم الدورة: ");
                courseName = scanner.nextLine();
                course = college.findCourse(courseName);
                if (course != null) {
                    System.out.print("اسم الأستاذ الكامل: ");
                    String professorName = scanner.nextLine();
                    Professors professor = college.findProfessor(professorName);
                    if (professor != null) {
                        if (course.assignProfessor(professor)) {
                            System.out.println("تم تعيين الأستاذ بنجاح.");
                        } else {
                            System.out.println("الدورة تحتوي بالفعل على أستاذ.");
                        }
                    } else {
                        System.out.println("الأستاذ غير موجود.");
                    }
                } else {
                    System.out.println("الدورة غير موجودة.");
                }
                break;

            case "d": // هل الدورة تحتوي على أستاذ؟
                System.out.print("اسم الدورة: ");
                courseName = scanner.nextLine();
                course = college.findCourse(courseName);
                if (course != null) {
                    System.out.println("هل الدورة تحتوي على أستاذ؟ " + (course.isAssigned() ? "نعم" : "لا"));
                } else {
                    System.out.println("الدورة غير موجودة.");
                }
                break;

            case "e": // اسم الأستاذ المعين
                System.out.print("اسم الدورة: ");
                courseName = scanner.nextLine();
                course = college.findCourse(courseName);
                if (course != null) {
                    System.out.println("اسم الأستاذ: " + course.professorName());
                } else {
                    System.out.println("الدورة غير موجودة.");
                }
                break;

            case "f": // هل الدورة ممتلئة؟
                System.out.print("اسم الدورة: ");
                courseName = scanner.nextLine();
                course = college.findCourse(courseName);
                if (course != null) {
                    System.out.println("الدورة ممتلئة؟ " + (course.isFull() ? "نعم" : "لا"));
                } else {
                    System.out.println("الدورة غير موجودة.");
                }
                break;

            case "g": // تسجيل طالب في الدورة
                System.out.print("اسم الدورة: ");
                courseName = scanner.nextLine();
                course = college.findCourse(courseName);
                if (course != null) {
                    System.out.print("اسم الطالب الكامل: ");
                    String studentName = scanner.nextLine();
                    Students student = college.findStudent(studentName);
                    if (student != null) {
                        if (course.enroll(student)) {
                            System.out.println("تم تسجيل الطالب في الدورة بنجاح.");
                        } else {
                            System.out.println("الدورة ممتلئة أو الطالب غير مسجل في القسم المرتبط.");
                        }
                    } else {
                        System.out.println("الطالب غير موجود.");
                    }
                } else {
                    System.out.println("الدورة غير موجودة.");
                }
                break;

            case "h": // تقرير الدورة
                System.out.print("اسم الدورة: ");
                courseName = scanner.nextLine();
                course = college.findCourse(courseName);
                if (course != null) {
                    System.out.println("تقرير الدورة:");
                    System.out.println("الوصف: " + course.getDescription());
                    System.out.println("القسم: " + course.getDepartment());
                    System.out.println("عدد المحاضرات: " + course.getNumberOfLectures());
                    System.out.println("الحد الأقصى للطلاب: " + course.getMaxNumberOfStudents());
                    System.out.println("عدد الطلاب: " + course.numberOfStudents());
                    System.out.println("حالة الدورة: " + (course.isFull() ? "ممتلئة" : "غير ممتلئة"));
                    System.out.println("الأستاذ: " + course.professorName());
                } else {
                    System.out.println("الدورة غير موجودة.");
                }
                break;

            default:
                System.out.println("خيار غير صحيح.");
        }
    }

    //التعامل مع عمليات الأستاذ
    private static void handleProfessorOperations(College college, Scanner scanner) {
        System.out.println("\nعمليات الأستاذ:");
        System.out.println("a) أستاذ جديد");
        System.out.println("b) عرض الراتب");
        System.out.println("c) تعديل الراتب");
        System.out.println("d) تقرير");
        System.out.print("اختر عملية: ");

        String option = scanner.nextLine();

        switch (option) {
            case "a": // أستاذ جديد
                System.out.print("الاسم الأول: ");
                String firstName = scanner.nextLine();
                System.out.print("اسم العائلة: ");
                String lastName = scanner.nextLine();
                System.out.print("رقم الهاتف: ");
                String phone = scanner.nextLine();
                System.out.print("العنوان: ");
                String address = scanner.nextLine();
                System.out.print("الراتب: ");
                double salary = scanner.nextDouble();
                scanner.nextLine();
                Professors professor = new Professors(firstName, lastName, phone, address, salary);
                college.addProfessor(professor);
                System.out.println("تم إضافة الأستاذ بنجاح.");
                break;

            case "b": // عرض الراتب
                System.out.print("اسم الأستاذ الكامل: ");
                String professorName = scanner.nextLine();
                Professors prof = college.findProfessor(professorName);
                if (prof != null) {
                    System.out.println("الراتب: " + prof.getSalary());
                } else {
                    System.out.println("الأستاذ غير موجود.");
                }
                break;

            case "c": // تعديل الراتب
                System.out.print("اسم الأستاذ الكامل: ");
                professorName = scanner.nextLine();
                prof = college.findProfessor(professorName);
                if (prof != null) {
                    System.out.print("نسبة الزيادة (بالأرقام العشرية، مثال: 0.1): ");
                    double raise = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("الراتب الجديد: " + prof.getRaise(raise));
                } else {
                    System.out.println("الأستاذ غير موجود.");
                }
                break;

            case "d": // تقرير
                System.out.print("اسم الأستاذ الكامل: ");
                professorName = scanner.nextLine();
                prof = college.findProfessor(professorName);
                if (prof != null) {
                    System.out.println("تقرير الأستاذ:");
                    System.out.println("الاسم: " + prof.fullName());
                    System.out.println("الهاتف: " + prof.getTelephone());
                    System.out.println("العنوان: " + prof.getAddress());
                    System.out.println("الراتب: " + prof.getSalary());
                } else {
                    System.out.println("الأستاذ غير موجود.");
                }
                break;

            default:
                System.out.println("خيار غير صحيح.");
        }
    }

    // التعامل مع عمليات الطالب
    private static void handleStudentOperations(College college, Scanner scanner) {
        System.out.println("\nعمليات الطالب:");
        System.out.println("a) طالب جديد");
        System.out.println("b) تقرير");
        System.out.print("اختر عملية: ");

        String option = scanner.nextLine();

        switch (option) {
            case "a": // طالب جديد
                System.out.print("الاسم الأول: ");
                String firstName = scanner.nextLine();
                System.out.print("اسم العائلة: ");
                String lastName = scanner.nextLine();
                System.out.print("رقم الهاتف: ");
                String phone = scanner.nextLine();
                System.out.print("العنوان: ");
                String address = scanner.nextLine();
                System.out.print("العمر: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.print("اسم القسم: ");
                String departmentName = scanner.nextLine();
                Departments department = college.findDepartment(departmentName);

                if (department != null) {
                    Students student = new Students (firstName, lastName, phone, address, age, department);
                    college.addStudent(student);
                    department.enroll(student);
                    System.out.println("تم إضافة الطالب وتسجيله في القسم بنجاح.");
                } else {
                    System.out.println("القسم غير موجود.");
                }
                break;

            case "b": // تقرير
                System.out.print("اسم الطالب الكامل: ");
                String studentName = scanner.nextLine();
                Students student = college.findStudent(studentName);
                if (student != null) {
                    System.out.println("تقرير الطالب:");
                    System.out.println("الاسم: " + student.fullName());
                    System.out.println("الهاتف: " + student.getTelephone());
                    System.out.println("العنوان: " + student.getAddress());
                    System.out.println("العمر: " + student.getAge());
                    System.out.println("القسم: " + student.getDepartment().getName());
                    System.out.println("الدورات: " + student.getCourses().size());
                } else {
                    System.out.println("الطالب غير موجود.");
                }
                break;

            default:
                System.out.println("خيار غير صحيح.");
        }
    }




    // باقي العمليات مثل التعامل مع الدورات، الأساتذة، والطلاب يمكن بناؤها بطريقة مشابهة.
}
