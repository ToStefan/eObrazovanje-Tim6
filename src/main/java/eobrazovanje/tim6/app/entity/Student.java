package eobrazovanje.tim6.app.entity;

import java.util.Iterator;

public class Student {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String index;
	private Long accountBalance;
	private String adress;
	private String phoneNumber;
	private Boolean deleted = false;
	private Integer version;
	
	public User user;
	public java.util.Collection<Payment> payment;
	public java.util.Set<Document> document;
	public java.util.Set<Course> course;
	public java.util.Set<ExamRegistration> examRegistration;
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(Long newId) {
		
		id = newId;
	}
	
	public String getFirstName() {
		
		return firstName;
	}
	
	public void setFirstName(String newFirstName) {
		
		firstName = newFirstName;
	}
	
	public String getLastName() {
		
		return lastName;
	}
	
	public void setLastName(String newLastName) {
		
		lastName = newLastName;
	}
	
	public String getIndex() {
		
		return index;
	}
	
	public void setIndex(String newIndex) {
		
		index = newIndex;
	}
	
	public Long getAccountBalance() {
		
		return accountBalance;
	}
	
	public void setAccountBalance(Long newAccountBalance) {
		
		accountBalance = newAccountBalance;
	}
	
	public String getAdress() {
		
		return adress;
	}
	
	public void setAdress(String newAdress) {
		
		adress = newAdress;
	}
	
	public String getPhoneNumber() {
		
		return phoneNumber;
	}
	
	public void setPhoneNumber(String newPhoneNumber) {
		
		phoneNumber = newPhoneNumber;
	}
	
	public Boolean getDeleted() {
		
		return deleted;
	}
	
	public void setDeleted(Boolean newDeleted) {
		
		deleted = newDeleted;
	}
	
	public Integer getVersion() {
		
		return version;
	}
	
	public void setVersion(Integer newVersion) {
		
		version = newVersion;
	}
	
	public java.util.Collection<Payment> getPayment() {
		
		if (payment == null)
			payment = new java.util.HashSet<Payment>();
		return payment;
	}
	
	public Iterator getIteratorPayment() {
		
		if (payment == null)
			payment = new java.util.HashSet<Payment>();
		return payment.iterator();
	}
	
	public void setPayment(java.util.Collection<Payment> newPayment) {
		
		removeAllPayment();
		for (Iterator iter = newPayment.iterator(); iter.hasNext();)
			addPayment((Payment) iter.next());
	}
	
	public void addPayment(Payment newPayment) {
		
		if (newPayment == null)
			return;
		if (this.payment == null)
			this.payment = new java.util.HashSet<Payment>();
		if (!this.payment.contains(newPayment)) {
			this.payment.add(newPayment);
			newPayment.setStudent(this);
		}
	}
	
	public void removePayment(Payment oldPayment) {
		
		if (oldPayment == null)
			return;
		if (this.payment != null)
			if (this.payment.contains(oldPayment)) {
				this.payment.remove(oldPayment);
				oldPayment.setStudent((Student) null);
			}
	}
	
	public void removeAllPayment() {
		
		if (payment != null) {
			Payment oldPayment;
			for (Iterator iter = getIteratorPayment(); iter.hasNext();) {
				oldPayment = (Payment) iter.next();
				iter.remove();
				oldPayment.setStudent((Student) null);
			}
		}
	}
	
	public java.util.Set<Document> getDocument() {
		
		if (document == null)
			document = new java.util.HashSet<Document>();
		return document;
	}
	
	public Iterator getIteratorDocument() {
		
		if (document == null)
			document = new java.util.HashSet<Document>();
		return document.iterator();
	}
	
	public void setDocument(java.util.Set<Document> newDocument) {
		
		removeAllDocument();
		for (Iterator iter = newDocument.iterator(); iter.hasNext();)
			addDocument((Document) iter.next());
	}
	
	public void addDocument(Document newDocument) {
		
		if (newDocument == null)
			return;
		if (this.document == null)
			this.document = new java.util.HashSet<Document>();
		if (!this.document.contains(newDocument)) {
			this.document.add(newDocument);
			newDocument.setStudent(this);
		}
	}
	
	public void removeDocument(Document oldDocument) {
		
		if (oldDocument == null)
			return;
		if (this.document != null)
			if (this.document.contains(oldDocument)) {
				this.document.remove(oldDocument);
				oldDocument.setStudent((Student) null);
			}
	}
	
	public void removeAllDocument() {
		
		if (document != null) {
			Document oldDocument;
			for (Iterator iter = getIteratorDocument(); iter.hasNext();) {
				oldDocument = (Document) iter.next();
				iter.remove();
				oldDocument.setStudent((Student) null);
			}
		}
	}
	
	public java.util.Set<Course> getCourse() {
		
		if (course == null)
			course = new java.util.HashSet<Course>();
		return course;
	}
	
	public Iterator getIteratorCourse() {
		
		if (course == null)
			course = new java.util.HashSet<Course>();
		return course.iterator();
	}
	
	public void setCourse(java.util.Set<Course> newCourse) {
		
		removeAllCourse();
		for (Iterator iter = newCourse.iterator(); iter.hasNext();)
			addCourse((Course) iter.next());
	}
	
	public void addCourse(Course newCourse) {
		
		if (newCourse == null)
			return;
		if (this.course == null)
			this.course = new java.util.HashSet<Course>();
		if (!this.course.contains(newCourse))
			this.course.add(newCourse);
	}
	
	public void removeCourse(Course oldCourse) {
		
		if (oldCourse == null)
			return;
		if (this.course != null)
			if (this.course.contains(oldCourse))
				this.course.remove(oldCourse);
	}
	
	public void removeAllCourse() {
		
		if (course != null)
			course.clear();
	}
	
	public java.util.Set<ExamRegistration> getExamRegistration() {
		
		if (examRegistration == null)
			examRegistration = new java.util.HashSet<ExamRegistration>();
		return examRegistration;
	}
	
	public Iterator getIteratorExamRegistration() {
		
		if (examRegistration == null)
			examRegistration = new java.util.HashSet<ExamRegistration>();
		return examRegistration.iterator();
	}
	
	public void setExamRegistration(java.util.Set<ExamRegistration> newExamRegistration) {
		
		removeAllExamRegistration();
		for (java.util.Iterator iter = newExamRegistration.iterator(); iter.hasNext();)
			addExamRegistration((ExamRegistration) iter.next());
	}
	
	public void addExamRegistration(ExamRegistration newExamRegistration) {
		
		if (newExamRegistration == null)
			return;
		if (this.examRegistration == null)
			this.examRegistration = new java.util.HashSet<ExamRegistration>();
		if (!this.examRegistration.contains(newExamRegistration)) {
			this.examRegistration.add(newExamRegistration);
			newExamRegistration.setStudent(this);
		}
	}
	
	public void removeExamRegistration(ExamRegistration oldExamRegistration) {
		
		if (oldExamRegistration == null)
			return;
		if (this.examRegistration != null)
			if (this.examRegistration.contains(oldExamRegistration)) {
				this.examRegistration.remove(oldExamRegistration);
				oldExamRegistration.setStudent((Student) null);
			}
	}
	
	public void removeAllExamRegistration() {
		
		if (examRegistration != null) {
			ExamRegistration oldExamRegistration;
			for (Iterator iter = getIteratorExamRegistration(); iter.hasNext();) {
				oldExamRegistration = (ExamRegistration) iter.next();
				iter.remove();
				oldExamRegistration.setStudent((Student) null);
			}
		}
	}
	
}
