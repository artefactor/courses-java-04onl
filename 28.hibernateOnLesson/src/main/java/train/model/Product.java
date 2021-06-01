package train.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

@Entity
@Table
public class Product implements IEntity {
	static Random r = new Random();
	@Id
	@GeneratedValue
	Long id;

	long a = r.nextLong();
	long b = r.nextLong();
	long c = r.nextLong();
	long d = r.nextLong();
	long e = r.nextLong();
	long f = r.nextLong();
	long g = r.nextLong();
	long h = r.nextLong();
	long j = r.nextLong();
	long k = r.nextLong();
	long l = r.nextLong();
	long m = r.nextLong();
	long n = r.nextLong();

	@Temporal(TemporalType.TIMESTAMP) Date  a1 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  b1 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  c1 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  d1 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  e1 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  f1 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  g1 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  h1 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  j1 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  k1 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  l1 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  m1 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  n1 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  a11 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  b11 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  c11 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  d11 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  e11 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  f11 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  g11 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  h11 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  j11 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  k11 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  l11 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  m11 = new Date();
	@Temporal(TemporalType.TIMESTAMP) Date  n11 = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getA() {
		return a;
	}

	public void setA(long a) {
		this.a = a;
	}

	public long getB() {
		return b;
	}

	public void setB(long b) {
		this.b = b;
	}

	public long getC() {
		return c;
	}

	public void setC(long c) {
		this.c = c;
	}

	public long getD() {
		return d;
	}

	public void setD(long d) {
		this.d = d;
	}

	public long getE() {
		return e;
	}

	public void setE(long e) {
		this.e = e;
	}

	public long getF() {
		return f;
	}

	public void setF(long f) {
		this.f = f;
	}

	public long getG() {
		return g;
	}

	public void setG(long g) {
		this.g = g;
	}

	public long getH() {
		return h;
	}

	public void setH(long h) {
		this.h = h;
	}

	public long getJ() {
		return j;
	}

	public void setJ(long j) {
		this.j = j;
	}

	public long getK() {
		return k;
	}

	public void setK(long k) {
		this.k = k;
	}

	public long getL() {
		return l;
	}

	public void setL(long l) {
		this.l = l;
	}

	public long getM() {
		return m;
	}

	public void setM(long m) {
		this.m = m;
	}

	public long getN() {
		return n;
	}

	public void setN(long n) {
		this.n = n;
	}

	public Date getA1() {
		return a1;
	}

	public void setA1(Date a1) {
		this.a1 = a1;
	}

	public Date getB1() {
		return b1;
	}

	public void setB1(Date b1) {
		this.b1 = b1;
	}

	public Date getC1() {
		return c1;
	}

	public void setC1(Date c1) {
		this.c1 = c1;
	}

	public Date getD1() {
		return d1;
	}

	public void setD1(Date d1) {
		this.d1 = d1;
	}

	public Date getE1() {
		return e1;
	}

	public void setE1(Date e1) {
		this.e1 = e1;
	}

	public Date getF1() {
		return f1;
	}

	public void setF1(Date f1) {
		this.f1 = f1;
	}

	public Date getG1() {
		return g1;
	}

	public void setG1(Date g1) {
		this.g1 = g1;
	}

	public Date getH1() {
		return h1;
	}

	public void setH1(Date h1) {
		this.h1 = h1;
	}

	public Date getJ1() {
		return j1;
	}

	public void setJ1(Date j1) {
		this.j1 = j1;
	}

	public Date getK1() {
		return k1;
	}

	public void setK1(Date k1) {
		this.k1 = k1;
	}

	public Date getL1() {
		return l1;
	}

	public void setL1(Date l1) {
		this.l1 = l1;
	}

	public Date getM1() {
		return m1;
	}

	public void setM1(Date m1) {
		this.m1 = m1;
	}

	public Date getN1() {
		return n1;
	}

	public void setN1(Date n1) {
		this.n1 = n1;
	}

	public Date getA11() {
		return a11;
	}

	public void setA11(Date a11) {
		this.a11 = a11;
	}

	public Date getB11() {
		return b11;
	}

	public void setB11(Date b11) {
		this.b11 = b11;
	}

	public Date getC11() {
		return c11;
	}

	public void setC11(Date c11) {
		this.c11 = c11;
	}

	public Date getD11() {
		return d11;
	}

	public void setD11(Date d11) {
		this.d11 = d11;
	}

	public Date getE11() {
		return e11;
	}

	public void setE11(Date e11) {
		this.e11 = e11;
	}

	public Date getF11() {
		return f11;
	}

	public void setF11(Date f11) {
		this.f11 = f11;
	}

	public Date getG11() {
		return g11;
	}

	public void setG11(Date g11) {
		this.g11 = g11;
	}

	public Date getH11() {
		return h11;
	}

	public void setH11(Date h11) {
		this.h11 = h11;
	}

	public Date getJ11() {
		return j11;
	}

	public void setJ11(Date j11) {
		this.j11 = j11;
	}

	public Date getK11() {
		return k11;
	}

	public void setK11(Date k11) {
		this.k11 = k11;
	}

	public Date getL11() {
		return l11;
	}

	public void setL11(Date l11) {
		this.l11 = l11;
	}

	public Date getM11() {
		return m11;
	}

	public void setM11(Date m11) {
		this.m11 = m11;
	}

	public Date getN11() {
		return n11;
	}

	public void setN11(Date n11) {
		this.n11 = n11;
	}
}
