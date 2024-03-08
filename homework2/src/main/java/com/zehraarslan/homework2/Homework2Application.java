package com.zehraarslan.homework2;

import com.zehraarslan.homework2.dto.CompanyDto;
import com.zehraarslan.homework2.dto.CustomerDto;
import com.zehraarslan.homework2.dto.OrderDto;
import com.zehraarslan.homework2.entity.Company;
import com.zehraarslan.homework2.entity.Customer;
import com.zehraarslan.homework2.entity.Order;
import com.zehraarslan.homework2.mapper.CompanyMapper;
import com.zehraarslan.homework2.mapper.CustomerMapper;
import com.zehraarslan.homework2.mapper.OrderMapper;
import com.zehraarslan.homework2.repository.CompanyRepository;
import com.zehraarslan.homework2.repository.CustomerRepository;
import com.zehraarslan.homework2.repository.OrderRepository;
import com.zehraarslan.homework2.request.CompanySaveRequest;
import com.zehraarslan.homework2.request.CustomerSaveRequest;
import com.zehraarslan.homework2.request.OrderSaveRequest;
import com.zehraarslan.homework2.service.CompanyService;
import com.zehraarslan.homework2.service.CustomerService;
import com.zehraarslan.homework2.service.OrderService;
import com.zehraarslan.homework2.service.impl.CompanyServiceImpl;
import com.zehraarslan.homework2.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Homework2Application implements CommandLineRunner{

	@Autowired
	private CustomerService customerService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(Homework2Application.class, args);
	}

	public void run(String... args) {
		CustomerSaveRequest customer1 = new CustomerSaveRequest("Ayşe Yılmaz", "Teknoloji", "ayse.yilmaz@example.com", "5551234567", LocalDate.of(2024, 6, 1));
		CustomerSaveRequest customer2 = new CustomerSaveRequest("Mustafa Kaya", "Eğitim", "mustafa.kaya@example.com", "5552345678", LocalDate.of(2024, 6, 2));
		CustomerSaveRequest customer3 = new CustomerSaveRequest("Zeynep Öztürk", "Sağlık", "zeynep.ozturk@example.com", "5553456789", LocalDate.of(2024, 6, 3));
		CustomerSaveRequest customer4 = new CustomerSaveRequest("Emre Can", "Yazılım", "emre.can@example.com", "5554567890", LocalDate.of(2024, 6, 4));
		CustomerSaveRequest customer5 = new CustomerSaveRequest("Ceren Şahin", "Otomotiv", "fatma.sahin@example.com", "5555678901", LocalDate.of(2024, 6, 5));
		List<CustomerSaveRequest> customerRequests = Arrays.asList(customer1, customer2, customer3, customer4, customer5);
		customerService.saveAll(customerRequests);

		CompanySaveRequest company1 = new CompanySaveRequest("ABC Teknoloji A.Ş.", "Bilişim", "iletisim@abcteknoloji.com", "02121234567", "İstanbul, Maslak");
		CompanySaveRequest company2 = new CompanySaveRequest("DEF İnşaat Ltd. Şti.", "İnşaat", "info@definsaat.com", "02162345678", "İstanbul, Levent");
		CompanySaveRequest company3 = new CompanySaveRequest("GHI Mobilya San. ve Tic. A.Ş.", "Mobilya", "bilgi@ghimobilya.com", "03121234567", "Ankara, Çankaya");
		CompanySaveRequest company4 = new CompanySaveRequest("JKL Gıda A.Ş.", "Gıda", "info@jklgida.com", "03122345678", "İzmir, Konak");
		CompanySaveRequest company5 = new CompanySaveRequest("MNO Eğitim Danışmanlık Ltd. Şti.", "Eğitim", "info@mnoegitim.com", "02321234567", "İstanbul, Kadıköy");
		List<CompanySaveRequest> companyRequests = Arrays.asList(company1, company2, company3, company4, company5);
		companyService.saveAll(companyRequests);

		OrderSaveRequest order1 = new OrderSaveRequest(1L, 1L, 1500.0, LocalDate.of(2024, 6, 1));
		OrderSaveRequest order2 = new OrderSaveRequest(2L, 2L, 2500.0, LocalDate.of(2024, 6, 2));
		OrderSaveRequest order3 = new OrderSaveRequest(3L, 3L, 1800.0, LocalDate.of(2024, 6, 3));
		OrderSaveRequest order4 = new OrderSaveRequest(4L, 4L, 2000.0, LocalDate.of(2024, 6, 4));
		OrderSaveRequest order5 = new OrderSaveRequest(5L, 5L, 3000.0, LocalDate.of(2024, 6, 5));
		OrderSaveRequest order6 = new OrderSaveRequest(1L, 3L, 500.0, LocalDate.of(2024, 6, 1));
		OrderSaveRequest order7 = new OrderSaveRequest(2L, 2L, 200.0, LocalDate.of(2024, 6, 2));
		OrderSaveRequest order8 = new OrderSaveRequest(3L, 2L, 100.0, LocalDate.of(2024, 6, 3));
		OrderSaveRequest order9 = new OrderSaveRequest(4L, 1L, 200.0, LocalDate.of(2024, 6, 4));
		OrderSaveRequest order10 = new OrderSaveRequest(5L, 2L, 300.0, LocalDate.of(2024, 6, 5));
		List<OrderSaveRequest> orderRequests = Arrays.asList(order1, order2, order3, order4, order5, order6, order7, order8, order9, order10);
		orderService.saveAll(orderRequests);

		System.out.println("--------------------");

		// List all customers
		List<CustomerDto> allCustomers = customerService.getAll();
		System.out.println("List of all customers: ");
		allCustomers.forEach(customer -> System.out.println(customer.toString()));
		System.out.println("-----------------------------");


		// List all companies
		List<CompanyDto> allCompanies = companyService.getAll();
		System.out.println("List of all companies: ");
		allCompanies.forEach(company -> System.out.println(company.toString()));
		System.out.println("-----------------------------");


		// List all orders
		List<OrderDto> allInvoices = orderService.getAll();
		System.out.println("List of all invoices: ");
		allInvoices.forEach(invoice -> System.out.println(invoice.toString()));
		System.out.println("-----------------------------");


		// List customers containing the letter 'C'
		List<CustomerDto> customersWithC = customerService.getCustomersWithNameContainingC();
		System.out.println("Customers with 'C': ");
		customersWithC.forEach(customer -> System.out.println(customer.toString()));
		System.out.println("--------------------");


		// Total amount of orders in June
		double totalAmountInJune = orderService.getAverageAmountOfOrdersAbove(6);
		System.out.println("Total amount of orders in June: " + totalAmountInJune);
		System.out.println("--------------------");

		// List orders above 1500 TL
		List<OrderDto> ordersAbove1500 = orderService.getOrdersWithAmountGreaterThan(1500);
		System.out.println("Orders above 1500 TL: ");
		ordersAbove1500.forEach(order -> System.out.println(order.toString()));
		System.out.println("--------------------");

		// Calculate the average amount of orders above 1500 TL
		double averageAmountAbove1500 = orderService.getAverageAmountOfOrdersAbove(1500);
		System.out.println("Average amount of orders above 1500 TL: " + averageAmountAbove1500);
		System.out.println("--------------------");

		// List names of customers with orders below 500 TL
		List<String> customersWithOrdersBelow500 = orderService.getCustomersWithOrdersBelow(500);
		System.out.println("Customers with orders below 500 TL: ");
		customersWithOrdersBelow500.forEach(System.out::println);
		System.out.println("--------------------");

		// List sectors of companies with average orders below 750 TL in June
		List<String> companiesWithAverageBelow750 = orderService.findByInvoiceDateMonthAndAmountGreaterThanEqual(6, 750);
		System.out.println("Companies with average orders below 750 in June: ");
		companiesWithAverageBelow750.forEach(System.out::println);
		System.out.println("--------------------");


	}
}
