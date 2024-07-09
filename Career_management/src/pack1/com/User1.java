package pack1.com;

public class User1 {
    private String name;
    private String education;
    private String experience;
    private String skills;
    private String careerGoals;

    public User1(String name) {
        this.name = name;
    }

    public void User(String string) {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters for each attribute
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }

    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }

    public String getCareerGoals() { return careerGoals; }
    public void setCareerGoals(String careerGoals) { this.careerGoals = careerGoals; }

    @Override
    public String toString() {
        return "Name: " + name +
               "\nEducation: " + education +
               "\nExperience: " + experience +
               "\nSkills: " + skills +
               "\nCareer Goals: " + careerGoals;
    }
}

