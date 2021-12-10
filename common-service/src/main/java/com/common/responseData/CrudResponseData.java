package com.common.responseData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



public class CrudResponseData<T> {

	protected ResponseEntity<T> create(Optional<T> data){
		if (!data.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(data.get());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(data.get());
	}
	
	protected ResponseEntity<T> update(Optional<T> oldData,T newData) {
		if(oldData.get() == null) {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(newData);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(oldData.get());
	}

	protected ResponseEntity<List<T>> readAll(List<T> data) {
		if (data.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ArrayList<>());
		}
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
	
	protected ResponseEntity<Page<T>> readAllByPage(Optional<Page<T>> data) {
		if (data.get().isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Page.empty());
		}
		return ResponseEntity.status(HttpStatus.OK).body(data.get());
	}

	protected ResponseEntity<T> readOne(Optional<T> data) {
		if (!data.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(data.get());
	}	
	
	
	protected ResponseEntity<String> delete(boolean isDeleted){
		if(!isDeleted) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Not Deleted");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted");
	}
	
	
}
