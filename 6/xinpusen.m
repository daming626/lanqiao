function s=xinpusen(a,b,n)  
%���sΪ���ֵ���ֵ�⣬����(a,b)Ϊ�������䣬nΪ�ȷ�����ĸ���.
x=a:(b-a)/(2*n):b;
s=(b-a)/n/6*(f(x(1))+f(x(2*n+1))); 
for i=2:2:2*n
    s=s+2*(b-a)/(3*n)*f(x(i));       
end
for i=3:2:2*n-1
    s=s+(b-a)/(3*n)*f(x(i));
end
