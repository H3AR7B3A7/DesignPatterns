package CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern2 {
    public static void main(String[] args) {
        Member member1 = new Member("Draco", "Slytherin");
        Member member2 = new Member("Vincent", "Slytherin");

        Member member3 = new Member("Hermione", "Gryffindor");
        Member member4 = new Member("Ron", "Gryffindor");
        Member member5 = new Member("Harry", "Gryffindor");

        CompositeMember compositeMember1 = new CompositeMember("Severus", "Slytherin");
        compositeMember1.addMember(member1);
        compositeMember1.addMember(member2);
        CompositeMember compositeMember2 = new CompositeMember("Minerva", "Gryffindor");
        compositeMember2.addMember(member3);
        compositeMember2.addMember(member4);
        compositeMember2.addMember(member5);

        CompositeMember compositeMember3 = new CompositeMember("Albus", "Headmasters");
        compositeMember3.addMember(compositeMember1);
        compositeMember3.addMember(compositeMember2);

        System.out.println("School structure");
        compositeMember3.printStructures();
        System.out.printf("Total of: %d members.\r\n", compositeMember3.getMemberCount() + 1);

        System.out.println("Slytherin structure:");

        compositeMember1.printStructures();
        System.out.printf("Total of: %d members.\r\n", compositeMember1.getMemberCount() + 1);

        System.out.println("Gryffindor structure:");

        compositeMember2.printStructures();
        System.out.printf("Total of: %d members.\r\n", compositeMember2.getMemberCount() + 1);
    }
}

interface IMember {
    void printStructures();

    int getMemberCount();
}

class CompositeMember implements IMember {
    private int memberCount = 0;
    private String name;
    private String group;
    private List<IMember> pupils;

    public CompositeMember(String name, String group) {
        this.name = name;
        this.group = group;
        pupils = new ArrayList<>();
    }

    public void addMember(IMember member) {
        pupils.add(member);
    }

    public void removeMember(IMember member) {
        pupils.remove(member);
    }

    @Override
    public void printStructures() {
        System.out.println("\t" + this.name + " belongs to " + this.group);
        for (IMember member : pupils) {
            member.printStructures();
        }
    }

    @Override
    public int getMemberCount() {
        memberCount = pupils.size();
        for (IMember member : pupils) {
            memberCount += member.getMemberCount();
        }
        return memberCount;
    }
}

class Member implements IMember {
    private String name;
    private String group;
    private int memberCount = 0;

    public Member(String name, String group) {
        this.name = name;
        this.group = group;
    }

    @Override
    public void printStructures() {
        System.out.println("\t" + this.name + " belongs to " + this.group);
    }

    @Override
    public int getMemberCount() {
        return memberCount;
    }
}