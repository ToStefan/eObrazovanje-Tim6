package eobrazovanje.tim6.app.web.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eobrazovanje.tim6.app.entity.Payment;
import eobrazovanje.tim6.app.service.impl.PaymentService;
import eobrazovanje.tim6.app.web.dto.PaymentDTO;
import eobrazovanje.tim6.app.web.mapper.PaymentMapper;

@RestController
@RequestMapping(value = "/")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private PaymentMapper paymentMapper;
	
	
	//General:
	//?page=0&size=3
	@GetMapping(value = "api/payments")
	public ResponseEntity<Set<PaymentDTO>> getPayments(Pageable pageable){
		Page<Payment> payments = paymentService.findAll(pageable);
		if(payments == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Set<PaymentDTO>>(paymentMapper.toDTO(payments), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "api/payments/{id}")
	public ResponseEntity<PaymentDTO> getDocument(@PathVariable("id") Long id){
		Payment payment = paymentService.findOne(id);
		if(payment == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PaymentDTO>(paymentMapper.toDTO(payment), HttpStatus.OK);
		
	}
	
	//Nested:
	
	@GetMapping(value = "api/students/{id}/payments")
	public ResponseEntity<Set<PaymentDTO>> getStudentPayments(@PathVariable("id") Long id, Pageable pageable){
		Page<Payment> studentPayments = paymentService.findByStudentId(id, pageable);
		if(studentPayments == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Set<PaymentDTO>>(paymentMapper.toDTO(studentPayments), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "api/students/{student-id}/payments/{payment-id}")
	public ResponseEntity<PaymentDTO> getStudentPayment(@PathVariable("student-id") Long studentId, @PathVariable("payment-id") Long documentId){
		Payment studentPayment = paymentService.findOneByStudentId(documentId, studentId);
		if(studentPayment == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PaymentDTO>(paymentMapper.toDTO(studentPayment), HttpStatus.OK);
		
	}
	
	//Create, Update, Delete:
	

	@PostMapping(value = "api/payments", consumes = "application/json")
	public ResponseEntity<PaymentDTO> savePayment(@RequestBody PaymentDTO paymentDTO){
		if(paymentDTO == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Payment payment = paymentService.save(paymentMapper.toEntity(paymentDTO));
		return new ResponseEntity<PaymentDTO>(paymentMapper.toDTO(payment), HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "api/payments", consumes = "application/json")
	public ResponseEntity<PaymentDTO> updatePayment(@RequestBody PaymentDTO paymentDTO){
		Payment payment = paymentService.findOne(paymentDTO.getId());
		if (payment == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		payment = paymentService.save(paymentMapper.toExistingEntity(payment, paymentDTO));
		return new ResponseEntity<PaymentDTO>(paymentMapper.toDTO(payment), HttpStatus.CREATED);	
	}
	
	@DeleteMapping(value = "api/payments/{id}")
	public ResponseEntity<Void> deletePayment(@PathVariable("id") Long id){
		if(paymentService.remove(id)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	

}
