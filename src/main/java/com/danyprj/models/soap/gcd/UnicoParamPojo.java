package com.danyprj.models.soap.gcd;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnicoParamPojo {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	

	private Integer firstNumber;
	private Integer secondNumber;
	private Integer sumNumber;
	private Integer gcdNumber;


	public UnicoParamPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UnicoParamPojo [id=" + id + ", firstNumber=" + firstNumber + ", secondNumber=" + secondNumber
				+ ", sumNumber=" + sumNumber + ", gcdNumber=" + gcdNumber + "]";
	}

	public UnicoParamPojo(Long id, Integer firstNumber, Integer secondNumber, Integer sumNumber, Integer gcdNumber) {
		super();
		this.id = id;
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.sumNumber = sumNumber;
		this.gcdNumber = gcdNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Integer getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(Integer firstNumber) {
		this.firstNumber = firstNumber;
	}

	public Integer getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(Integer secondNumber) {
		this.secondNumber = secondNumber;
	}

	public Integer getSumNumber() {
		return sumNumber;
	}

	public void setSumNumber(Integer sumNumber) {
		this.sumNumber = sumNumber;
	}

	public Integer getGcdNumber() {
		return gcdNumber;
	}

	public void setGcdNumber(Integer gcdNumber) {
		this.gcdNumber = gcdNumber;
	}
	
	
}
