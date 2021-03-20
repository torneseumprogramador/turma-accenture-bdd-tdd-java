package com.danilo.tdd_bdd.validadorCpf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.InputMismatchException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidadorCpfApplicationTests {

	@Test
	void fazendoTesteDeCpfValido() {
		assertEquals(true, isCPF("94622036010"));
	}

	@Test
	void fazendoTesteDeCpfInvalido() {
		assertEquals(false, isCPF("94622036011"));
	}

	@Test
	void fazendoTesteDeCpfComDigitoAMenos() {
		assertEquals(false, isCPF("9462203602"));
	}

	@Test
	void fazendoTesteDeCpfValidoComPontos() {
		assertEquals(true, isCPF("946.220.360-10"));
	}

	@Test
	void fazendoTesteDeCpfInvalidoComPontos() {
		assertEquals(false, isCPF("946.220.360-11"));
	}

	@Test
	void fazendoTesteDeCpfInvalidoComVirgula() {
		assertEquals(false, isCPF("946,220.360-11"));
	}

	@Test
	void fazendoTesteDeCpfInvalidoComEspacoNoFinal() {
		assertEquals(true, isCPF("946.220.360-10 "));
	}
	
	@Test
	void fazendoTesteDeCpfInvalidoComEspacoNoComeco() {
		assertEquals(true, isCPF(" 946.220.360-10"));
	}
	
	@Test
	void fazendoTesteDeCpfInvalidoComEspacoNoMeio() {
		assertEquals(true, isCPF("946.220. 360-10"));
	}

	public boolean isCPF(String CPF) {
		CPF = CPF.replace(".", "").replace("-", "").replace(" ", "");

		if (CPF.equals("00000000000") ||
				CPF.equals("11111111111") ||
				CPF.equals("22222222222") || CPF.equals("33333333333") ||
				CPF.equals("44444444444") || CPF.equals("55555555555") ||
				CPF.equals("66666666666") || CPF.equals("77777777777") ||
				CPF.equals("88888888888") || CPF.equals("99999999999") ||
				(CPF.length() != 11))
				return(false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
				sm = 0;
				peso = 10;
				for (i=0; i<9; i++) {
				num = (int)(CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
				}

				r = 11 - (sm % 11);
				if ((r == 10) || (r == 11))
						dig10 = '0';
				else dig10 = (char)(r + 48);

				sm = 0;
				peso = 11;
				for(i=0; i<10; i++) {
				num = (int)(CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
				}

				r = 11 - (sm % 11);
				if ((r == 10) || (r == 11))
						 dig11 = '0';
				else dig11 = (char)(r + 48);

				if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
						 return(true);
				else return(false);
						} catch (InputMismatchException erro) {
						return(false);
				}
		}
}
