package pl.mb2k15;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;


@Table(name = "usermodel")
@Entity
public class UserModel {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid;

    private String usrName;

    private String usrPasswd;

    private String usrDesc;

  /*  private String uuid = UUID.randomUUID().toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserModel userModel = (UserModel) o;

        return uuid != null ? uuid.equals(userModel.uuid) : userModel.uuid == null;
    }

    @Override
    public int hashCode() {
        return uuid != null ? uuid.hashCode() : 0;
    }

*/



    public UserModel() {
    }

    public UserModel(String usrName, String usrPasswd) {
        this.usrPasswd = usrPasswd;
        this.usrName = usrName;
    }

    public int getUsrId() {
        return userid;
    }

    public void setUsrId(int usrId) {
        this.userid = usrId;
    }

    public String getUsrName() {
        return usrName;
    }


    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getUsrPasswd() {
        return usrPasswd;
    }

    public void setUsrPasswd(String usrPasswd) {
        this.usrPasswd = usrPasswd;
    }

    public String getUsrDesc() {
        return usrDesc;
    }

    public void setUsrDesc(String usrDesc) {
        this.usrDesc = usrDesc;
    }



    @Override
    public String toString() {
        return "UserModel{" +
                "userid=" + userid +
                ", usrName='" + usrName + '\'' +
                ", usrPasswd='" + usrPasswd + '\'' +
                ", usrDesc='" + usrDesc + '\'' +
                '}';
    }
}
