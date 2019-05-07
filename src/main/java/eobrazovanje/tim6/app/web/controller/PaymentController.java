package eobrazovanje.tim6.app.web.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
import eobrazovanje.tim6.app.service.impl.StudentService;
import eobrazovanje.tim6.app.web.dto.PaymentDTO;

@RestController
@RequestMapping(value = "/")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private StudentService studentService;
	
	//General:
	
	@GetMapping(value = "api/payments")
	public ResponseEntity<Set<PaymentDTO>> getPayments(){
		List<Payment> payments = paymentService.findAll();
		if(payments == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Set<PaymentDTO>>(PaymentDTO.paymentsToDTOs(payments), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "api/payments/{id}")
	public ResponseEntity<PaymentDTO> getDocument(@PathVariable("id") Long id){
		Payment payment = paymentService.findOne(id);
		if(payment == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PaymentDTO>(new PaymentDTO(payment), HttpStatus.OK);
		
	}
	
	//Nested:
	
	@GetMapping(value = "api/students/{id}/payments")
	public ResponseEntity<Set<PaymentDTO>> getStudentPayments(@PathVariable("id") Long id){
		List<Payment> studentPayments = paymentService.findByStudentId(id);
		if(studentPayments == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Set<PaymentDTO>>(PaymentDTO.paymentsToDTOs(studentPayments), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "api/students/{student-id}/payments/{payment-id}")
	public ResponseEntity<PaymentDTO> getStudentPayment(@PathVariable("student-id") Long studentId, @PathVariable("payment-id") Long documentId){
		Payment studentPayment = paymentService.findOneByStudentId(documentId, studentId);
		if(studentPayment == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PaymentDTO>(new PaymentDTO(studentPayment), HttpStatus.OK);
		
	}
	
	//Create, Update, Delete:
	

	@PostMapping(value = "api/payments", consumes = "application/json")
	public ResponseEntity<PaymentDTO> savePayment(@RequestBody PaymentDTO paymentDTO){
		if(paymentDTO == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Payment payment = new Payment();
		payment.setPaymentPurpose(paymentDTO.getPaymentPurpose());
		payment.setAmount(paymentDTO.getAmount());
		payment.setDate(new Date());
		payment.setStudent(studentService.findOne(paymentDTO.getStudent().getId()));
		payment.setDeleted(false);
		
		
		payment = paymentService.save(payment);
		return new ResponseEntity<PaymentDTO>(new PaymentDTO(payment), HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "api/payments", consumes = "application/json")
	public ResponseEntity<PaymentDTO> updatePayment(@RequestBody PaymentDTO paymentDTO){
		Payment payment = paymentService.findOne(paymentDTO.getId());
		if (payment == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		payment.setPaymentPurpose(paymentDTO.getPaymentPurpose());
		payment.setAmount(paymentDTO.getAmount());
		payment.setDate(new Date());
		payment.setStudent(studentService.findOne(paymentDTO.getStudent().getId()));
		payment.setDeleted(false);
		
		
		payment = paymentService.save(payment);
		return new ResponseEntity<PaymentDTO>(new PaymentDTO(payment), HttpStatus.CREATED);	
	}
	
	@DeleteMapping(value = "api/payments/{id}")
	public ResponseEntity<Void> deletePayment(@PathVariable("id") Long id){
		Payment payment = paymentService.findOne(id);
		if(payment == null ) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		payment.setDeleted(true);
		paymentService.save(payment);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	
	

}