task :release do
  temp = "../temp"
  puts `git clone -l -s -b gh-pages . #{temp}`
  if system("mvn release:perform")
      puts `cd #{temp} && git add -A && git commit -m "releasing artifacts" && git push origin gh-pages`
      puts `git push origin gh-pages`
      puts " artifact released successfully "
  else
    puts " could not release artifact "
  end
  puts `rm -r #{temp}`
end