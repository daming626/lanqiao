function s=tixing(a,b,n)  
%输出s为积分的数值解，输入(a,b)为积分区间，n为等分区间的个数.
x=a:(b-a)/n:b;
s=(b-a)/n/2*(f(x(1))+f(x(n+1))); 
for i=2:n
    s=s+(b-a)/n*f(x(i));       
end
