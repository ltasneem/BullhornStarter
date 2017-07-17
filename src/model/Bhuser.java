package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bhuser database table.
 * 
 */
@Entity
@Table(name="bhuser")
@NamedQuery(name="Bhuser.findAll", query="SELECT b FROM Bhuser b")
public class Bhuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BHUSERID")
	private int bhuserid;

	@Column(name="GRAVATARURL")
	private String gravatarurl;

	@Temporal(TemporalType.DATE)
	@Column(name="JOINDATE")
	private Date joindate;

	@Column(name="MOTTO")
	private String motto;

	@Column(name="USEREMAIL")
	private String useremail;

	@Column(name="USERNAME")
	private String username;

	@Column(name="USERPASSWORD")
	private String userpassword;

	//bi-directional many-to-one association to Bhpost
	@OneToMany(mappedBy="bhuser")
	private List<Bhpost> bhposts;

	public Bhuser() {
	}

	public int getBhuserid() {
		return this.bhuserid;
	}

	public void setBhuserid(int bhuserid) {
		this.bhuserid = bhuserid;
	}

	public String getGravatarurl() {
		return this.gravatarurl;
	}

	public void setGravatarurl(String gravatarurl) {
		this.gravatarurl = gravatarurl;
	}

	public Date getJoindate() {
		return this.joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public String getMotto() {
		return this.motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public String getUseremail() {
		return this.useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return this.userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public List<Bhpost> getBhposts() {
		return this.bhposts;
	}

	public void setBhposts(List<Bhpost> bhposts) {
		this.bhposts = bhposts;
	}

	public Bhpost addBhpost(Bhpost bhpost) {
		getBhposts().add(bhpost);
		bhpost.setBhuser(this);

		return bhpost;
	}

	public Bhpost removeBhpost(Bhpost bhpost) {
		getBhposts().remove(bhpost);
		bhpost.setBhuser(null);

		return bhpost;
	}

}