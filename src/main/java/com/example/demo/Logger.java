package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOGGER")
public class Logger {

	private String LogType;
	private LocalDate date;
	private LocalTime time;
	@Id
	private String Id;
	public String getLogType() {
		return LogType;
	}
	public void setLogType(String logType) {
		this.LogType = logType;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		this.Id = id;
	}
	
	@Override
	public String toString() {
		return "Logger [LogType=" + LogType + ", date=" + date + ", time=" + time + ", Id=" + Id + "]";
	}
	
}