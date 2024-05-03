package models;

public class Email {
    private String emailType;
    private String scheduleFrequency;
    private String sendTime;

    public Email(String emailType, String scheduleFrequency, String sendTime) {
        this.emailType = emailType;
        this.scheduleFrequency = scheduleFrequency;
        this.sendTime = sendTime;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getScheduleFrequency() {
        return scheduleFrequency;
    }

    public void setScheduleFrequency(String scheduleFrequency) {
        this.scheduleFrequency = scheduleFrequency;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
