package sd.wekala.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import sd.wekala.aspect.PermissionCheck;
import sd.wekala.exception.ClientNotFoundException;
import sd.wekala.model.Client;
import sd.wekala.model.Invoice;
import sd.wekala.model.Product;
import sd.wekala.model.ProductType;
import sd.wekala.model.Stock;
import sd.wekala.model.User;
import sd.wekala.model.Weat;
import sd.wekala.repository.ClientRepository;
import sd.wekala.repository.InvoiceRepository;
import sd.wekala.repository.ProductRepository;
import sd.wekala.repository.ProductTypeRepository;
import sd.wekala.repository.StockRepository;
import sd.wekala.repository.UserRepository;
import sd.wekala.repository.WeatRepository;
import sd.wekala.util.Workspace;

@Controller
public class MainController implements ErrorController {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private WeatRepository weatRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@GetMapping({ "/", "/login" })
	public String login() {
		return "login";
	}

	@GetMapping("dashboard")
	@PermissionCheck(workspace = { Workspace.DASHBOARD }, read = true)
	public String dashboard(Model model) {
		model.addAttribute("client", new Client());

		List<Client> clientSize = clientRepository.findAll();
		List<Weat> weatSize = weatRepository.findAll();
		List<Product> productSize = productRepository.findAll();
		List<Stock> stockSize = stockRepository.findAll();
		List<User> userSize = userRepository.findAll();

		model.addAttribute("clientSize", clientSize.size());
		model.addAttribute("weatSize", weatSize.size());
		model.addAttribute("productSize", productSize.size());
		model.addAttribute("stockSize", stockSize.size());
		model.addAttribute("userSize", userSize.size());

		return "index";
	}

	// Save Client And AL-Makhabiz
	@PostMapping("/createClient")
	public String saveCompanyPartner(@ModelAttribute Client client) {
		clientRepository.save(client);
		return "redirect:Bakery";
	}

	// Search Client By AL-Makhabaz Name
	@GetMapping(path = "/searchClient")
	@PermissionCheck(workspace = { Workspace.CLIENT_SEARCH }, read = true)
	public String searchClient(@RequestParam(value = "search", required = false) String q, Model model)
			throws ClassNotFoundException {
		Iterable<Client> clients = clientRepository.findByClientNameContaining(q);
		model.addAttribute("clients", clients);
		return "/searchClient";
	}

	// get AL-Makhabaz Name by Id
	@GetMapping("/client/{id}")
	@PermissionCheck(workspace = { Workspace.CLIENT_SEARCH }, read = true)
	public String clientDetail(@PathVariable(value = "id") Long id, Model model) throws ClientNotFoundException {
		Client cilent = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException());
		model.addAttribute("clients", cilent);
		return "clientDetail";
	}

	@GetMapping("/clientProduct/{id}")
	@PermissionCheck(workspace = { Workspace.BAKERY }, read = true)
	public String viewClientProduct(@PathVariable(value = "id") Long id, Model model) throws ClientNotFoundException {
		Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException());
		model.addAttribute("clients", client);
		List<Invoice> invoices = invoiceRepository.findByC(client);
		int invoiceSize = invoices.size();
		model.addAttribute("invoices", invoices);
		model.addAttribute("invoiceSize", invoiceSize);
		return "/clientProduct";
	}

	@GetMapping("/clientInvoices/{id}")
	@PermissionCheck(workspace = { Workspace.BAKERY }, read = true)
	public String viewclientInvoices(@PathVariable(value = "id") Long id, Model model) throws ClientNotFoundException {
		Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException());
		model.addAttribute("invoice", new Invoice());
		model.addAttribute("clientInvoice", invoiceRepository.findByC(client));
		model.addAttribute("products", productRepository.findAll());
		model.addAttribute("clients", client);

		// invoiceRepository
		return "/clientInvoices";
	}

	// Get All AL-Makhabaz Name As a List
	@GetMapping("/Bakery")
	@PermissionCheck(workspace = { Workspace.BAKERY }, read = true)
	public String viewBakery(Model model) {
		model.addAttribute("client", new Client());
		model.addAttribute("clients", clientRepository.findAll());
		return "/backary";
	}

	@GetMapping("/productManagement")
	@PermissionCheck(workspace = { Workspace.BAKERY }, read = true)
	public String viewProductManagement(Model model) {

		model.addAttribute("product", new Product());
		model.addAttribute("products", productRepository.findAll());

		return "/productManagement";
	}

	// Create, Delete Product
	@GetMapping("/newProduct")
	@PermissionCheck(workspace = { Workspace.BAKERY }, read = true)
	public String viewNewProduct(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("weat", new Weat());
		model.addAttribute("stock", new Stock());
		model.addAttribute("productType", new ProductType());

		model.addAttribute("productTypes", productTypeRepository.findAll());
		model.addAttribute("stocks", stockRepository.findAll());
		model.addAttribute("weats", weatRepository.findAll());
		return "/newProduct";
	}

	// Get All Weat Company Name As A List
	@GetMapping("/weatCompany")
	@PermissionCheck(workspace = { Workspace.BAKERY }, read = true)
	public String viewWeatCompany(Model model) {
		model.addAttribute("weat", new Weat());
		model.addAttribute("weats", weatRepository.findAll());
		return "/weatCompany";
	}

	// Create Invoice
	@PostMapping("/createInvoice")
	@PermissionCheck(workspace = { Workspace.BAKERY }, read = true)
	public String saveInvoice(@ModelAttribute Invoice invoice) {
		invoiceRepository.save(invoice);

		Product product = invoice.getP();
		int invoiceQty = invoice.getQty();
		int productQty = invoice.getP().getQty();
		int lastQty = productQty - invoiceQty;
		product.setQty(lastQty);
		productRepository.save(product);

		return "redirect:Bakery";
	}

	// Create Weat Company
	@PostMapping("/createWeatCompany")
	@PermissionCheck(workspace = { Workspace.BAKERY }, read = true)
	public String saveWeatCompany(@ModelAttribute Weat weat) {
		weatRepository.save(weat);
		return "redirect:weatCompany";
	}

	// Create Product Type From Product
	@PostMapping("createProductType")
	@PermissionCheck(workspace = { Workspace.BAKERY }, read = true)
	public String saveProductType(@ModelAttribute ProductType productType) {
		productTypeRepository.save(productType);
		return "redirect:newProduct";
	}

	// Create Weat Company from Product Management
	@PostMapping("/createWeatForProduct")
	@PermissionCheck(workspace = { Workspace.CLIENT_SEARCH }, read = true)
	public String saveWeatFromProduct(@ModelAttribute Weat weat) {
		weatRepository.save(weat);
		return "redirect:newProduct";
	}

	// Create Stock from Product Management
	@PostMapping("/createStockForProduct")
	@PermissionCheck(workspace = { Workspace.CLIENT_SEARCH }, read = true)
	public String saveStockFromProduct(@ModelAttribute Stock stock) {
		stockRepository.save(stock);
		return "redirect:newProduct";
	}

	// Get Client Invoice
	@GetMapping("/invoice/{id}")
	@PermissionCheck(workspace = { Workspace.CLIENT_SEARCH }, read = true)
	public String invoiceDetail(@PathVariable(value = "id") Long id, Model model) throws ClientNotFoundException {
		Invoice invoice = invoiceRepository.findById(id).orElseThrow(() -> new ClientNotFoundException());
		Client client = clientRepository.findClientByInvoice(invoice);
		LocalDate invoiceDate = LocalDate.now();
		model.addAttribute("invoiceDate", invoiceDate);
		model.addAttribute("clientInvoice", invoice);
		model.addAttribute("client", client);
		model.addAttribute("products", productRepository.findAll());
		return "invoice";
	}

	// get AL-Makhabaz Name by Id
	@GetMapping("/weat/{id}")
	@PermissionCheck(workspace = { Workspace.CLIENT_SEARCH }, read = true)
	public String weatDetail(@PathVariable(value = "id") Long id, Model model) throws ClientNotFoundException {
		Weat weat = weatRepository.findById(id).orElseThrow(() -> new ClientNotFoundException());
		model.addAttribute("weats", weat);
		return "weatDetail";
	}

	// Search Weat Company by Company Name
	@GetMapping(path = "/searchWeat")
	@PermissionCheck(workspace = { Workspace.CLIENT_SEARCH }, read = true)
	public String searchWeatCompany(@RequestParam(value = "search", required = false) String q, Model model)
			throws ClassNotFoundException {
		Iterable<Weat> weats = weatRepository.findByWeatNameContaining(q);
		model.addAttribute("weats", weats);
		return "/searchWeat";
	}

	// Access Denied
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "/accessDenied";
	}

	// Create Product
	@PostMapping("/createProduct")
	@PermissionCheck(workspace = { Workspace.BAKERY }, read = true)
	public String saveProduct(@ModelAttribute Product product) {
		productRepository.save(product);
		return "redirect:productManagement";
	}

	// Delete Product
	@DeleteMapping("/deleteProduct")
	public String deleteProduct(@ModelAttribute Product product) {
		productRepository.delete(product);
		return "redirect:productManagement";
	}

	// Delete Al-Makhbaz
	@RequestMapping(value = "/deleteClient/{id}", method = RequestMethod.GET)
	public String deleteClient(@PathVariable Long id) {
		clientRepository.deleteById(id);
		return "redirect:/Bakery";
	}

	// Delete Weat Company
	@RequestMapping(value = "/deleteWeat/{id}", method = RequestMethod.GET)
	public String deleteWeat(@PathVariable Long id) {
		weatRepository.deleteById(id);
		return "redirect:/weatCompany";
	}

	// Handle To 404 Not Found Exception
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@RequestMapping(value = "/error")
	public String error404() throws RequestRejectedException {
		return "notFound";
	}

	// Handle To 404 Not Found Exception
	@Override
	public String getErrorPath() throws RequestRejectedException {
		return "/notFound";
	}
}
