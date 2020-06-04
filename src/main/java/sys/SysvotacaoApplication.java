package sys;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sys.domain.Enquete;
import sys.domain.OpcoesVotos;
import sys.repositories.EnqueteRepository;
import sys.repositories.OpcoesVotosRepository;

@SpringBootApplication
public class SysvotacaoApplication implements CommandLineRunner {
	
	@Autowired
	private OpcoesVotosRepository opcoesVotosRepository;
	
	@Autowired
	private EnqueteRepository enqueteRepository;

	public static void main(String[] args) {
		SpringApplication.run(SysvotacaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				
		Enquete e1 = new Enquete(null, sdf.parse("30/09/2019 10:32"), sdf.parse("30/09/2020 10:32"), "Em quem vc votaria para presidente em 2022?", "Em_andamento");
		Enquete e2 = new Enquete(null, sdf.parse("01/07/2020 10:32"), sdf.parse("30/10/2020 10:32"), "Como voce avalia o meu trabalho?", "Não_iniciada");
		Enquete e3 = new Enquete(null, sdf.parse("01/09/2017 10:32"), sdf.parse("23/12/2017 10:32"), "Qual o navegador voce costuma usar?", "Finalizada");
		Enquete e4 = new Enquete(null, sdf.parse("01/01/2020 10:32"), sdf.parse("01/01/2021 10:32"), "Qual a linguagem mais usada atualmente, em programação?", "Em_andamento");
								
		OpcoesVotos op1 = new OpcoesVotos(null, "Bolssonaro", e1);
		OpcoesVotos op2 = new OpcoesVotos(null, "Boulos", e1);
		OpcoesVotos op3 = new OpcoesVotos(null, "Marina", e1);
		
		OpcoesVotos op4 = new OpcoesVotos(null, "Horrível", e2);
		OpcoesVotos op5 = new OpcoesVotos(null, "Razoável", e2);
		OpcoesVotos op6 = new OpcoesVotos(null, "Dá pra passar", e2);
		OpcoesVotos op7 = new OpcoesVotos(null, "Infelizmente não é o que procuramos", e2);
		
		OpcoesVotos op8 = new OpcoesVotos(null, "Opera", e3);
		OpcoesVotos op9 = new OpcoesVotos(null, "Mozila", e3);
		OpcoesVotos op10 = new OpcoesVotos(null, "Chrome", e3);
		
		OpcoesVotos op11 = new OpcoesVotos(null, "Java", e4);
		OpcoesVotos op12 = new OpcoesVotos(null, "PHP", e4);
		OpcoesVotos op13 = new OpcoesVotos(null, "JavaScript", e4);
		
		opcoesVotosRepository.saveAll(Arrays.asList(op1, op2, op3, op4, op5, op6, op7, op8, op9, op10, op11, op12, op13));
		enqueteRepository.saveAll(Arrays.asList(e1, e2, e3, e4));
	
	}

}
