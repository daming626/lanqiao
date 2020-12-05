function s=xinpusen(a,b,n)  
%输出s为积分的数值解，输入(a,b)为积分区间，n为等分区间的个数.
x=a:(b-a)/(2*n):b;
s=(b-a)/n/6*(f(x(1))+f(x(2*n+1))); 
for i=2:2:2*n
    s=s+2*(b-a)/(3*n)*f(x(i));       
end
for i=3:2:2*n-1
    s=s+(b-a)/(3*n)*f(x(i));
end
